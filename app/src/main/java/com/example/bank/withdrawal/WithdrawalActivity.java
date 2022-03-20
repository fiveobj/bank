package com.example.bank.withdrawal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.bank.R;
import com.example.bank.deposit.MoneyAllDepositFragment;

public class WithdrawalActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.deposit_layout,new Withdrawal_all_Fragment());
        transaction.commit();
    }
}