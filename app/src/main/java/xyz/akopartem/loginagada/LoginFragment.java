package xyz.akopartem.loginagada;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LoginFragment extends Fragment implements Serializable {
    MainActivity activity;

    public LoginFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        Button loginButton = v.findViewById(R.id.loginBtn);
        Button cancelButton = v.findViewById(R.id.cancelBtn);
        loginButton.setOnClickListener(e -> {
            EditText et = v.findViewById(R.id.login);
            EditText passwordEt = v.findViewById(R.id.pass);
            String prt = "";
            if (!Validator.checkUsername(et.getText().toString())) {
                prt += "Username";
            }
            if (!Validator.checkPass(passwordEt.getText().toString())) {
                prt += prt.equals("") ? "Password" : " and password";
            }
            if (prt.equals("")) {
                activity.loadFragment(Successful.newInstance(et.getText().toString()));
            } else {
                prt += " can only contain english letters and digits nd can't be empty.";
                TextView eed = v.findViewById(R.id.tw);
                eed.setText(prt);
                eed.setTextColor(Color.RED);
            }
        });
        cancelButton.setOnClickListener(e -> {
            activity.loadFragment();
        });
        return v;
    }
}