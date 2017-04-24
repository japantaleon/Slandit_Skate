package com.example.android.slandit_skate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button BLogin = (Button) findViewById(R.id.BLogin);
        final Button BSignUp = (Button)findViewById(R.id.BSignUp);

        BLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, LogInform.class);
               MainActivity.this.startActivity(loginIntent);
            }
        });

        BSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUpIntent = new Intent(MainActivity.this, SignUpForm.class);
                MainActivity.this.startActivity(SignUpIntent);
            }
        });
    }
}
