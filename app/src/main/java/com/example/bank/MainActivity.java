package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bank.fragment.homeFragment;
import com.example.bank.fragment.moneyFragment;
import com.example.bank.fragment.myFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ImageView home,money,my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListeners();
    }

    private void initView()
    {
        home=findViewById(R.id.main_home);
        money=findViewById(R.id.main_money);
        my=findViewById(R.id.main_my);

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.main_layout,new homeFragment());
        transaction.commit();
    }

    private void setListeners(){
        OnClick onClick=new OnClick();
        home.setOnClickListener(onClick);
        money.setOnClickListener(onClick);
        my.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            transaction=manager.beginTransaction();
            switch (v.getId())
            {
                case R.id.main_home:
                    transaction.replace(R.id.main_layout,new homeFragment());
                    break;
                case R.id.main_money:
                    transaction.replace(R.id.main_layout,new moneyFragment());
                    break;
                case R.id.main_my:
                    transaction.replace(R.id.main_layout,new myFragment());
                    break;
                default:
                    break;
            }
            transaction.commit();
        }
    }
}