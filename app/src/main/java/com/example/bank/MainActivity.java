package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bank.fragment.homeFragment;
import com.example.bank.fragment.moneyFragment;
import com.example.bank.fragment.myFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ImageView home,money,my;
    private TextView hometv,moneytv,mytv;
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
        hometv=findViewById(R.id.main_hometv);
        moneytv=findViewById(R.id.main_moneytv);
        mytv=findViewById(R.id.main_mytv);
        hometv.setTextColor(Color.parseColor("#D90017"));
        home.setImageResource(R.mipmap.main_home0);

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
            Reimg();
            transaction=manager.beginTransaction();
            switch (v.getId())
            {
                case R.id.main_home:
                    transaction.replace(R.id.main_layout,new homeFragment());
                    hometv.setTextColor(Color.parseColor("#D90017"));
                    home.setImageResource(R.mipmap.main_home0);
                    break;
                case R.id.main_money:
                    transaction.replace(R.id.main_layout,new moneyFragment());
                    moneytv.setTextColor(Color.parseColor("#D90017"));
                    money.setImageResource(R.mipmap.main_money0);
                    break;
                case R.id.main_my:
                    transaction.replace(R.id.main_layout,new myFragment());
                    mytv.setTextColor(Color.parseColor("#D90017"));
                    my.setImageResource(R.mipmap.main_my0);
                    break;
                default:
                    break;
            }
            transaction.commit();
        }
    }

    private void Reimg()
    {
        mytv.setTextColor(Color.parseColor("#ff484e54"));
        my.setImageResource(R.mipmap.main_my);
        moneytv.setTextColor(Color.parseColor("#ff484e54"));
        money.setImageResource(R.mipmap.main_money);
        hometv.setTextColor(Color.parseColor("#ff484e54"));
        home.setImageResource(R.mipmap.main_home);
    }
}