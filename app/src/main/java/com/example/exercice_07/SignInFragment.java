package com.example.exercice_07;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;


public class SignInFragment extends Fragment {

    private EditText emailEt, passwordEt;
    ISignIn signIn;
    private Button btnSign;
    private Map<String, Identity> users;

    SignUpFragment signUpFragment;

    public SignInFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SignInFragment newInstance(String email, String password) {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        args.putString("email", email);
        args.putString("pass", password);
        fragment.setArguments(args);
        return fragment;
    }






    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailEt = view.findViewById(R.id.emailEt);
        passwordEt = view.findViewById(R.id.passwordEt);
        btnSign = view.findViewById(R.id.btnSingIn);
        signUpFragment = new SignUpFragment();


        Bundle arguments = getArguments();
        if (arguments != null) {
            String email = arguments.getString("email");
            String password = arguments.getString("password");
            emailEt.setText(email);
            passwordEt.setText(password);


        }



            btnSign.setOnClickListener(v -> {

                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();

                users = SignUpFragment.getIndentities();



                try {

                    Identity user = users.get(email);
                    assert user != null;
                    if (user.getPassword().equals(password)) {


                        String firstName = user.getFirstName();
                        String lastName = user.getLastName();
                        signIn.onSignIn(firstName, lastName);

                        Toast.makeText(getContext(), "Welcome :)", Toast.LENGTH_SHORT).show();
                    }
                }

                catch(Exception e ) {
                    Toast.makeText(getContext(), "A sahebiii nta rah makaynx :(", Toast.LENGTH_SHORT).show();

                }


                    });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        signIn = (ISignIn) context;
    }

    interface ISignIn {
        void onSignIn(String firstName, String lastName);
    }
}


