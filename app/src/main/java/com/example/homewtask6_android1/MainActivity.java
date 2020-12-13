package com.example.homewtask6_android1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements iFragments {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, ThirdFragment.newInstance("third fragment", ""))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFirstFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        fragmentTransaction.show(fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSecondFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        fragmentTransaction.hide(fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendMassage(String massage) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        ((TextView)fragment.getView().findViewById(R.id.txt_second)).setText(massage);
        fragmentTransaction.show(fragment)
                .addToBackStack(null)
                .commit();
    }
}