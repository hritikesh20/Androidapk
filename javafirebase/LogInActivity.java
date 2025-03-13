package com.example.javafirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInActivity extends AppCompatActivity {

    private EditText etUserName, etUserEmail, etUserBio, etUserPassword;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_log_in);
        super.onCreate(savedInstanceState);

        etUserName = findViewById(R.id.etUserName);
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserBio = findViewById(R.id.etUserBio);
        etUserPassword = findViewById(R.id.etUserPassword);
        Button btnSave = findViewById(R.id.btnSave);

        databaseReference = FirebaseDatabase.getInstance().getReference("UsersLogInInfo");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savDataToFirebase();
                startActivity(new Intent(LogInActivity.this, MainActivity.class));
            }
        });
    }

    private void savDataToFirebase() {

        String userName = etUserName.getText().toString().trim();
        String userEmail = etUserEmail.getText().toString().trim();
        String userBio = etUserBio.getText().toString().trim();
        String userPassword = etUserPassword.getText().toString().trim();

        if (userName.isEmpty() || userEmail.isEmpty() || userBio.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        // To generate unique key
        String userId = databaseReference.push().getKey();

        UserInfo userInfo = new UserInfo(userName, userEmail, userBio, userPassword);

        // save data to firebase
        if (userId != null) {
            databaseReference.child(userId).setValue(userInfo)
                    .addOnSuccessListener(aVoid ->
                            Toast.makeText(this, "SaveData Successfully", Toast.LENGTH_SHORT).show()
                    )
                    .addOnFailureListener(e ->
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    );
        }
    }

}