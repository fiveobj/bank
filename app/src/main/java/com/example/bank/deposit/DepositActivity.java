package com.example.bank.deposit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.bank.R;
import com.example.bank.fragment.homeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DepositActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private ImageView test;
    private TextView all,my;
    private boolean isall=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        all=findViewById(R.id.deposit_all);
        my=findViewById(R.id.deposit_my);

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

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exchangeImage(isall);
                transaction=manager.beginTransaction();
                transaction.replace(R.id.deposit_layout,new MoneyAllDepositFragment());
                transaction.commit();
                all.setTextColor(Color.parseColor("#ffff5639"));
                my.setTextColor(Color.parseColor("#ff484e54"));
            }
        });

        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exchangeImage(isall);
                transaction=manager.beginTransaction();
                transaction.replace(R.id.deposit_layout,new MoneyMyDepositFragment());
                transaction.commit();
                my.setTextColor(Color.parseColor("#ffff5639"));
                all.setTextColor(Color.parseColor("#ff484e54"));
            }
        });
    }

    private void exchangeImage(boolean isall)
    {
        if (isall){
            float fromx=0;
            float tox=440;
            Animation animation=new TranslateAnimation(fromx,tox,0,0);
            animation.setFillAfter(true);
            animation.setDuration(500);
            test.startAnimation(animation);
            this.isall=false;
        }
        else {
            float fromx=440;
            float tox=0;
            Animation animation=new TranslateAnimation(fromx,tox,0,0);
            animation.setFillAfter(true);
            animation.setDuration(500);
            test.startAnimation(animation);
            this.isall=true;
        }
    }

}