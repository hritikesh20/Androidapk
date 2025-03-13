package com.example.javafirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewHello);
        btnLogin = findViewById(R.id.btnLogIn);
        Button btnProfilePage = findViewById(R.id.btnProfilePage);
        Button btnPost = findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostUploadActivity.class);
                startActivity(intent);
            }
        });

        btnProfilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        // write data in realtime database
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Users");

//        myRef.setValue("Hello Firebase World");
        CustomReadWriteDataFromRealTimeFirebase();
        // Read data from realtime database

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String value = snapshot.getValue(String.class);
//                textView.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void CustomReadWriteDataFromRealTimeFirebase() {

        // RealTime db = FirebaseDatabase -> DatabaseReference
        // fireStore = FirebaseFireStore -> DocumentReference

        FirebaseDatabase database = FirebaseDatabase.getInstance(); // Realtime database
        DatabaseReference myDatabaseReference = database.getReference("Users"); // Realtime database

        // FirebaseFirestore db = FirebaseFirestore.getInstance();
        // DocumentReference myRef = db.collection("Users").document("Friends");// crud
        // CollectionReference collectionReference = db.collection("Users");

        // custom Write data
        User user1 = new User("HRitikesh", "HritikeshSingh20@gmail.com");
        myDatabaseReference.setValue(user1);

        // custom write data
        myDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                textView.setText("Email:" + user.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

/*
845247fc-77ce-46e1-a03e-15741c969b98
 */