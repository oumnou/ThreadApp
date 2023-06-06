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
    private Button btn_ok;
    private Map<String,ArrayList<String>> users;

    SignUpFragment signUpFragment;
    private String mParam1;
    private String mParam2;

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
        btn_ok = view.findViewById(R.id.btnSingIn);
        signUpFragment = new SignUpFragment();


        Bundle arguments = getArguments();
        if (arguments != null) {
            String email = arguments.getString("email");
            String password = arguments.getString("password");
            emailEt.setText(email);
            passwordEt.setText(password);


        }


        btn_ok.setOnClickListener(v -> {
           // try {
                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();

                //users = SignUpFragment.getUsers();

                //for (int i = 0; i < users.size(); i++) {
                    //if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {
                        //region Values to send to the AccountFragment
                        //firstName = users.get(i).getFirstName();
                       // lastName =  users.get(i).getLastName();
                        // signIn.onSignIn(firstName, lastName);
                        //endregion
                  //  }
                //}
            //} catch (Exception e) {
                Toast.makeText(getContext(), "The inputs are empty !!!", Toast.LENGTH_SHORT).show();
            //}
        //});


        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }



//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        signIn = (ISignIn) context;
//    }

    interface ISignIn {
        void onSignIn(String firstName, String lastName);
    }
}


