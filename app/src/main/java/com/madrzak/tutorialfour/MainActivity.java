package com.madrzak.tutorialfour;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.madrzak.tutorialfour.fragment.FirstFragment;
import com.madrzak.tutorialfour.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    private Button btnFragment1;
    private Button btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        changeFragment(new FirstFragment(), false);


        btnFragment1 = (Button) findViewById(R.id.btnFragment1);
        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new FirstFragment(), false);
            }
        });

        btnFragment2 = (Button) findViewById(R.id.btnFragment2);
        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new SecondFragment(), false);
            }
        });
    }

    public void changeFragment(Fragment target, Boolean addToBackStack) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(R.id.container, target);
        if (addToBackStack) {
            ft.addToBackStack(target.getTag());
        }
        ft.commit();

    }

}
