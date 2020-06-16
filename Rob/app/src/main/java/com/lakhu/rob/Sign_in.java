package com.lakhu.rob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Sign_in extends AppCompatActivity {

    EditText fname, uName, pass;
    Button register;
    FirebaseAuth fAuth;
    FirebaseAuth.AuthStateListener firebaseAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        fname = findViewById(R.id.editText1);
        uName = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);

        register = findViewById(R.id.button);

        fAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(Sign_in.this, Home_h.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("User");


        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Home_h.class));
            finish();
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = uName.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    uName.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    pass.setError("Password is Required");
                    return;
                }

                if (password.length() <8) {
                    pass.setError("Password is short");
                    return;
                }



                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String user_id = fAuth.getCurrentUser().getUid();


                            String name = fname.getText().toString();
                            String emailID = uName.getText().toString();
//                            DatabaseReference current_user = FirebaseDatabase.getInstance().getReference().child("Users").child(phone);

                            Map addPost = new HashMap();
                            addPost.put("Email-ID",emailID);
                            addPost.put("name",fname);

//                            current_user.setValue(addPost);


                            Toast.makeText(Sign_in.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home_h.class));


                        }else{
                            Toast.makeText(Sign_in.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }

                    }
                });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        fAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        fAuth.removeAuthStateListener(firebaseAuthListener);
    }
}



