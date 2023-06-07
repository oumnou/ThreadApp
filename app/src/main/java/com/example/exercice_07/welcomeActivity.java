package com.example.exercice_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class welcomeActivity extends AppCompatActivity implements SignInFragment.ISignIn {
    String fNmae, sName;
    WelcomeFragment welcomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String firstName = getIntent().getStringExtra("first name");
        String lastName = getIntent().getStringExtra("last name");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, WelcomeFragment.newInstance(firstName, lastName), null)
                .commit();

    }

    //region Handle Back button
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    //endregion


    @Override
    public void onSignIn(String firstName, String lastName) {
        welcomeFragment = WelcomeFragment.newInstance(firstName, lastName);


    }
}