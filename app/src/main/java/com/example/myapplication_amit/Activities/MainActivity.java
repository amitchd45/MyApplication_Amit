package com.example.myapplication_amit.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.myapplication_amit.Fragments.ChatFragment;
import com.example.myapplication_amit.Fragments.HomeFragment;
import com.example.myapplication_amit.Fragments.NotificationsFragment;
import com.example.myapplication_amit.Fragments.PeopleFragment;
import com.example.myapplication_amit.Fragments.SettingsFragment;
import com.example.myapplication_amit.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout frameLayout;
    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.framelayout);

        loadFragment(new HomeFragment());

        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_notification:
                fragment = new NotificationsFragment();
                break;
            case R.id.navigation_person:
                fragment = new PeopleFragment();
                break;
            case R.id.navigation_chat:
                fragment = new ChatFragment();
                break;
            case R.id.navigation_setting:
                fragment = new SettingsFragment();
                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
