package com.example.bank.withdrawal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bank.R;
import com.example.bank.deposit.MoneyAllDepositFragment;
import com.example.bank.deposit.MoneyMyDepositFragment;

public class WithdrawalActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private ImageView test;
    private TextView all,my;
    private boolean isall=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);

        all=findViewById(R.id.withdrawal_all);
        my=findViewById(R.id.withdrawal_my);
        test=findViewById(R.id.withdrawal_line);

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.deposit_layout,new Withdrawal_all_Fragment());
        transaction.commit();


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exchangeImage(isall);
                transaction=manager.beginTransaction();
                transaction.replace(R.id.deposit_layout,new Withdrawal_all_Fragment());
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
                transaction.replace(R.id.deposit_layout,new Withdrawal_my_Fragment());
                transaction.commit();
                my.setTextColor(Color.parseColor("#ffff5639"));
                all.setTextColor(Color.parseColor("#ff484e54"));
            }
        });
    }

    private void exchangeImage(boolean isall)
    {
        if (isall){
            float fromx=15;
            float tox=400;
            Animation animation=new TranslateAnimation(fromx,tox,0,0);
            animation.setFillAfter(true);
            animation.setDuration(500);
            test.startAnimation(animation);
            this.isall=false;
        }
        else {
            float fromx=400;
            float tox=15;
            Animation animation=new TranslateAnimation(fromx,tox,0,0);
            animation.setFillAfter(true);
            animation.setDuration(500);
            test.startAnimation(animation);
            this.isall=true;
        }
    }
}