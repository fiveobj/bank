package com.example.bank.deposit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.bank.R;
import com.example.bank.adapter.Money_deposit_all_son_adapter;
import com.example.bank.myclass.Money_deposit_all_item2;
import com.example.bank.tool.SpaceItemDecoration;

import java.util.ArrayList;

public class MoneyAllDepositSureActivity extends AppCompatActivity {

    private RecyclerView recyc;
    private ArrayList<Money_deposit_all_item2> list=new ArrayList<>();
    private Money_deposit_all_son_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_all_deposit_sure);

        recyc=findViewById(R.id.money_all_deposit_sure_recyc);
        list=getData();
        adapter=new Money_deposit_all_son_adapter(this,list);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyc.setLayoutManager(gridLayoutManager);
        recyc.addItemDecoration(new SpaceItemDecoration(0,20));
        recyc.setAdapter(adapter);

    }

    private ArrayList<Money_deposit_all_item2> getData() {

        ArrayList<Money_deposit_all_item2> list1=new ArrayList<>();

        list1.add(new Money_deposit_all_item2("1.72%","3个月-5年","50元起存","随时存取，灵活度大"));
        list1.add(new Money_deposit_all_item2("1.72%","3个月-5年","50元起存","随时存取，灵活度大"));
        list1.add(new Money_deposit_all_item2("1.72%","3个月-5年","50元起存","随时存取，灵活度大"));
        list1.add(new Money_deposit_all_item2("1.72%","3个月-5年","50元起存","随时存取，灵活度大"));
        list1.add(new Money_deposit_all_item2("1.72%","3个月-5年","50元起存","随时存取，灵活度大"));
        list1.add(new Money_deposit_all_item2("1.72%","3个月-5年","50元起存","随时存取，灵活度大"));

        return list1;
    }
}