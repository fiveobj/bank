package com.example.bank.deposit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.bank.R;
import com.example.bank.fragment.homeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DepositActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private ImageView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);




        test=findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fromx=100;
                float tox=360;
                Animation animation=new TranslateAnimation(fromx,tox,0,0);
                animation.setFillAfter(true);
                animation.setDuration(500);
                test.startAnimation(animation);
            }
        });

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.deposit_layout,new MoneyAllDepositFragment());
        transaction.commit();
    }
}