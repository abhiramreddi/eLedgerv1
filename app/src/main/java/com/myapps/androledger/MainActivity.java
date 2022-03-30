package com.myapps.androledger;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.myapps.androledger.fragments.History;
import com.myapps.androledger.fragments.Home;
import com.myapps.androledger.fragments.Ledger;
import com.myapps.androledger.fragments.Profile;
import com.myapps.androledger.fragments.Visualize;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Home fragment = new Home();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bnFragment, fragment, "");
        fragmentTransaction.commit();

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {

                case R.id.bnHome:
                    Home fragment1 = new Home();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.bnFragment, fragment1, "");
                    fragmentTransaction1.commit();
                    return true;

                case R.id.bnLedger:
                    Ledger fragment2 = new Ledger();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.bnFragment, fragment2, "");
                    fragmentTransaction2.commit();
                    return true;

                case R.id.bnVisualize:
                    Visualize fragment3 = new Visualize();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.bnFragment, fragment3);
                    fragmentTransaction3.commit();
                    return true;

                case R.id.bnHistory:
                    History fragment4 = new History();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.bnFragment, fragment4, "");
                    fragmentTransaction4.commit();
                    return true;


                case R.id.bnProfile:
                    Profile fragment5 = new Profile();
                    FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.bnFragment, fragment5, "");
                    fragmentTransaction5.commit();
                    return true;
            }
            return false;
        });


    }
}