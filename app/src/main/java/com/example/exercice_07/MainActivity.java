package com.example.exercice_07;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SignInFragment.ISignIn  {

    Button signInBtn;
    Button signUpBtn;
    SignInFragment signInFragment;
    SignUpFragment signUpFragment;



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn = findViewById(R.id.signInBtn);
        signUpBtn = findViewById(R.id.signUpBtn);

        signInFragment = new SignInFragment();
        signUpFragment = new SignUpFragment();


    getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, signInFragment, null)
                .commit();




        signUpBtn.setOnClickListener(v -> {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, signUpFragment, null)
                .commit();

        signUpBtn.setBackgroundColor(Color.parseColor("#61AFED"));
            signInBtn.setBackgroundColor(Color.parseColor("#673AB7"));
           // signInBtn.setBackgroundResource(R.color.white);
    });

        signInBtn.setOnClickListener(v -> {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, signInFragment, null)
                .commit();
            signUpBtn.setBackgroundColor(Color.parseColor("#673AB7"));
            //signUpBtn.setBackgroundResource(R.color.OFF);
            signInBtn.setBackgroundColor(Color.parseColor("#61AFED"));
    });

}

    @Override
    public void onSignIn(String firstName, String lastName) {
        Intent intent = new Intent(MainActivity.this, welcomeActivity.class);
        intent.putExtra("first name", firstName);
        intent.putExtra("last name", lastName);
        startActivity(intent);
    }
}