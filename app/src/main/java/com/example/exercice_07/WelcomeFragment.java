package com.example.exercice_07;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private String f;
    private String l;

    public WelcomeFragment() {
        // Required empty public constructor
    }
    public static WelcomeFragment newInstance(String firstName, String lastName) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();

        args.putString("last name", firstName);
        args.putString("first name", lastName);
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            l = getArguments().getString("last name");
            f = getArguments().getString("first name");

            System.out.printf(l);
            Log.d("test",f);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView last = view.findViewById(R.id.last);
        TextView first = view.findViewById(R.id.first);

        Toast.makeText(view.getContext(),f,Toast.LENGTH_SHORT).show();
        String nam = f +"  "+ l;

        Log.d("test",nam);

        first.setText(f);
        last.setText(l);

        // 18/07/2023

    }
}