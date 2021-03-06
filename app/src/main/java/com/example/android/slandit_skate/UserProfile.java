package com.skate.android.slandit_skate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.slandit_skate.BottomNavigationViewHelper;
import com.example.android.slandit_skate.Home;
import com.example.android.slandit_skate.Message;
import com.example.android.slandit_skate.Notification;
import com.example.android.slandit_skate.SearchData;
import com.skate.android.slandit_skate.LogInform;

/**
 * Created by panta on 4/23/2017.
 */

public class UserProfile extends AppCompatActivity{

    TextView uFirstName;
    TextView uLastname;
    TextView uCity;
    TextView uStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_icon:
                        Intent intent0 = new Intent(UserProfile.this, Home.class);
                        startActivity(intent0);
                        break;

                    case R.id.search_icon:
                        Intent intent1 = new Intent(UserProfile.this, SearchData.class);
                        startActivity(intent1);
                        break;

                    case R.id.message_icon:
                        Intent intent2 = new Intent(UserProfile.this, Message.class);
                        startActivity(intent2);
                        break;

                    case R.id.activity_icon:
                        Intent intent3 = new Intent(UserProfile.this, Notification.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }
}
