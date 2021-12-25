package xyz.akopartem.loginagada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new MainFragment(), "MainFragment");
    }

    public void loadFragment(Fragment f, String key) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag, f);
        ft.addToBackStack(key); // кладем fragmentы в стек (для хистори)
        ft.commit();
    }

    public void loadFragment(Fragment f) {
        loadFragment(f, null);
    }

    public void loadFragment() {
        super.onBackPressed();
    }

    /*
    public void loadFragment(String key) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment ft = (Fragment) fm.findFragmentByTag()
        FragmentTransaction frt = fm.beginTransaction();
        assert ft != null;
        frt.replace(R.id.frag, ft);
        frt.commit();
    }
    */


}