package com.example.exercice_07;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUpFragment extends Fragment {

    private EditText firstNameEt, lastNameEt, emailUpEt, passwordUpEt, confirmPassworEt;
    private Button btnSignUp;
    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance(String email, String password) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString("email", email);
        args.putString("password", password);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        firstNameEt = view.findViewById(R.id.firstNameEt);
        lastNameEt = view.findViewById(R.id.lastNameEt);
        emailUpEt = view.findViewById(R.id.emailUpEt);
        passwordUpEt = view.findViewById(R.id.passwordUpEt);
        confirmPassworEt = view.findViewById(R.id.confirmPassworEt);
        btnSignUp = view.findViewById(R.id.btnSignUp);
    }
}