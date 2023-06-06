package com.example.exercice_07;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SignUpFragment extends Fragment {



    static Map<String,Identity> allUsers =  new HashMap<>();
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





        btnSignUp.setOnClickListener(v -> {

            //region Create user Objects
            Identity user = new Identity();

            String first = String.valueOf(firstNameEt.getText());
            String last = String.valueOf(lastNameEt.getText());
            String email = String.valueOf(emailUpEt.getText());
            String pass = String.valueOf(passwordUpEt.getText());
            String conf = String.valueOf(confirmPassworEt.getText());




            if(last.equals("") || first.equals("") || email.equals("") || pass.equals("") || conf.equals("")) {

                Toast.makeText(getContext(), "emmmmmmmmm !!!", Toast.LENGTH_SHORT).show();

            } else {
                if (!conf.equals(pass)) { Toast.makeText(getContext(), "password not good !!!", Toast.LENGTH_SHORT).show();}

                else {
                    user.setFirstName(first);
                    user.setLastName(last);
                    user.setEmail(email);
                    user.setPassword(pass);

                    allUsers.put(email,user);

                    Toast.makeText(getContext(), "Account Created", Toast.LENGTH_SHORT).show();
                    SignInFragment signInFragment = SignInFragment.newInstance(email, pass);

                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, signInFragment)
                            .commit();

                }








            }
    });
}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }
}