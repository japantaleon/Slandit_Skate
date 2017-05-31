package com.example.android.slandit_skate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.skate.android.slandit_skate.R;
import com.skate.android.slandit_skate.UserProfile;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by panta on 5/30/2017.
 */

public class Notification extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        final CircleImageView leo = (CircleImageView) findViewById(R.id.leo);

        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proIntent = new Intent(Notification.this, UserProfile.class);
                Notification.this.startActivity(proIntent);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_icon:
                        Intent intent0 = new Intent(Notification.this, Home.class);
                        startActivity(intent0);
                        break;

                    case R.id.search_icon:
                        Intent intent1 = new Intent(Notification.this, SearchData.class);
                        startActivity(intent1);
                        break;

                    case R.id.message_icon:
                        Intent intent2 = new Intent(Notification.this, Message.class);
                        startActivity(intent2);
                        break;

                    case R.id.activity_icon:
                        Intent intent3 = new Intent(Notification.this, Notification.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
