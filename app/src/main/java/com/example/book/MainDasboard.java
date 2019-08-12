package com.example.book;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainDasboard extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dasboard);

        // kita set default nya Request Fragment
        loadFragment(new RequestFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.navigation_request:
                fragment = new RequestFragment();
                break;
            case R.id.navigation_listbooking:
                fragment = new ListbookingFragment();
                break;
            case R.id.navigation_approval:
                fragment = new ApprovalFragment();
                break;
            case R.id.navigation_logout:
                fragment = new LogoutFragment();
                break;
        }
        return loadFragment(fragment);
    }
}