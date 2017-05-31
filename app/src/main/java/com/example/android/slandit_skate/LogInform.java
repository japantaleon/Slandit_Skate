package com.skate.android.slandit_skate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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
import com.skate.android.slandit_skate.UserProfile;

/**
 * Created by panta on 4/22/2017.
 */

public class LogInform extends AppCompatActivity{

    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button ebutton =(Button) findViewById(R.id.btnLogin);
        final EditText inputEmail = (EditText)findViewById(R.id.loginEmail);
        final EditText inputPassword = (EditText)findViewById(R.id.loginPassword);
        final Button btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loIntent = new Intent(LogInform.this, UserProfile.class);
                LogInform.this.startActivity(loIntent);

            }
        });

}}
