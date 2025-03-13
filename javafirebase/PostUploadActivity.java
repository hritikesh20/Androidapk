package com.example.javafirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PostUploadActivity extends AppCompatActivity {
    EditText friendName, friendEmail;
    Button btnXsave, btnUpload, btnDelete, btnRead;
    FirebaseFirestore db;
    DocumentReference friendsRef;
    CollectionReference collectionReference;
    TextView friendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_upload);


        friendName = findViewById(R.id.enterFriendName);
        friendEmail = findViewById(R.id.enterFriendEmail);
        friendsList = findViewById(R.id.friedListTextView);

        btnXsave = findViewById(R.id.btnFriendSave);
        btnRead = findViewById(R.id.btnFriendRead);
        btnUpload = findViewById(R.id.btnFriendUploadData);
        btnDelete = findViewById(R.id.btnFriendDelete);


        db = FirebaseFirestore.getInstance();
        friendsRef = db.collection("FriendsUser").document("uQGIYFtGBMy59srNOYnW");
        collectionReference = db.collection("FriendsXUsers");


        btnXsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDataToNewDocument();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetAllDocument();
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSpecificDocument();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteAll();
            }
        });

    }

    void SaveDataToNewDocument() {

        String name = friendName.getText().toString();
        String email = friendEmail.getText().toString();

        // to Upload data
        Friend friend = new Friend(name, email);
        collectionReference.add(friend)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        String docId = documentReference.getId();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


    }

    void GetAllDocument() {
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                StringBuilder data = new StringBuilder();
                // This code is executed when data retrieval is successful
                // the QuerySnapshot contains the document in the collection
                for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots) {
                    // Transforming snapshots into objects
                    Friend friend = snapshot.toObject(Friend.class);
                    data.append("Name : ").append(friend.getName()).append("Email : ").append(friend.getEmail());
                }
//                friendsList.setText(data.toString());
                friendsList.post(() -> friendsList.setText(data.toString()));
            }
        });
    }

    void updateSpecificDocument() {
        String name = friendName.getText().toString();
        String email = friendEmail.getText().toString();
        friendsRef.update("name", name);
        friendsRef.update("email", email);


    }

    void DeleteAll() {
        friendsRef.delete();
    }
}