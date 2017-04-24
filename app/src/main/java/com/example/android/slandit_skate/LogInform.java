package com.example.android.slandit_skate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by panta on 4/22/2017.
 */

public class LogInform extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button ebutton =(Button) findViewById(R.id.ebutton);

        ebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(LogInform.this, UserProfile.class);
                LogInform.this.startActivity(LoginIntent);
            }
        });

    }
}
