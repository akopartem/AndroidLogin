package xyz.akopartem.loginagada;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.LocalDateTime;

public class Successful extends Fragment {

    private static final String FIRST_ARG_KEY = "uname";

    private String login;

    public Successful() {
    }

    public static Successful newInstance(String param1) {
        Successful fragment = new Successful();
        Bundle args = new Bundle();
        args.putString(FIRST_ARG_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    MainActivity context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = (MainActivity) context;
    }


    String res = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            login = getArguments().getString(FIRST_ARG_KEY);
        }
        LocalDateTime l = LocalDateTime.now();
        int hour = l.getHour();
        if (hour >= 22) {
            res += "Доброй ночи,\n";
        } else if (hour >= 18) {
            res += "Добрый вечер,\n";
        } else if (hour >= 12) {
            res += "Добрый день,\n";
        } else if (hour >= 6) {
            res += "Доброе утро,\n";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_successful, container, false);
        TextView text = view.findViewById(R.id.goodM);
        TextView uname = view.findViewById(R.id.uname);
        uname.setText(login);
        text.setText(res);
        text.setTextSize(40);
        uname.setTextSize(40);
        return view;
    }
}