package com.skate.android.slandit_skate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by panta on 4/22/2017.
 */

public class SignUpForm extends AppCompatActivity{

    private static final String TAG = com.skate.android.slandit_skate.MainActivity.class.getSimpleName();



    private EditText rFirstName;
    private EditText rLastName;
    private EditText rEmail;
    private EditText rPassword;

    private Button rJoinNow;

    private ProgressBar mProgress;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //Get Firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        rFirstName = (EditText) findViewById(R.id.fname);
        rLastName = (EditText) findViewById(R.id.lname);
        rEmail = (EditText) findViewById(R.id.email);
        rPassword = (EditText) findViewById(R.id.Password);
        rJoinNow = (Button) findViewById(R.id.BJoinNow);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);

        rJoinNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = rEmail.getText().toString().trim();
                String password = rPassword.getText().toString().trim();
                String fname = rFirstName.getText().toString().trim();
                String lname = rLastName.getText().toString().trim();


                if (TextUtils.isEmpty(fname)) {
                    Toast.makeText(getApplicationContext(), "Enter First Name!", Toast.LENGTH_SHORT).show();
                    return;
                }



                if (TextUtils.isEmpty(lname)) {
                    Toast.makeText(getApplicationContext(), "Enter Last Name!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mProgress.setVisibility(View.VISIBLE);
                //create user
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpForm.this, new OnCompleteListener<AuthResult>() {
                            @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUpForm.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                mProgress.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUpForm.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(SignUpForm.this, com.skate.android.slandit_skate.UserProfile.class));
                                    finish();
                                }
                            }
                        });

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgress.setVisibility(View.GONE);
    }
}
