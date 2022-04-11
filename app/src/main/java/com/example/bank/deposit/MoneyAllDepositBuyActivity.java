package com.example.bank.deposit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.bank.R;
import com.example.bank.fragment.homeFragment;

public class MoneyAllDepositBuyActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_all_deposit_buy);

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.deposit_buy_relative,new MoneyAllDepositBuy1Fragment());
        transaction.commit();

    }
}