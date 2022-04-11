package com.example.bank.deposit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.bank.R;
import com.example.bank.adapter.Money_deposit_all_son_adapter;
import com.example.bank.myclass.Money_deposit_all_item2;
import com.example.bank.tool.OKhttpClass;
import com.example.bank.tool.SpaceItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MoneyAllDepositSureActivity extends AppCompatActivity {

    private RecyclerView recyc;
    private ArrayList<Money_deposit_all_item2> list=new ArrayList<>();
    private Money_deposit_all_son_adapter adapter;
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_all_deposit_sure);
        Intent intent=getIntent();
        if (intent.getStringExtra("type")!=null)
        {
            type=intent.getStringExtra("type");
            getokhttpdata(type);
        }
        recyc=findViewById(R.id.money_all_deposit_sure_recyc);
        //list=getData();
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

    private void getokhttpdata(String type)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OKhttpClass oKhttpClass=new OKhttpClass();
                String result=oKhttpClass.ban3(type);
                Log.d("bank3",result);
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    String data=jsonObject.getString("data");
                    JSONArray jsonArray=new JSONArray(data);
                    String product1=jsonArray.get(0).toString();
                    JSONObject jsonObject1=new JSONObject(product1);
                    String product=jsonObject1.getString("product");
                    JSONArray jsonArray1=new JSONArray(product);
                    for (int i=0;i<jsonArray1.length();i++)
                    {
                        String data1=jsonArray1.get(i).toString();
                        JSONObject jsonObject2=new JSONObject(data1);
                        String rates=jsonObject2.getString("rates")+"%";
                        String startMoney=jsonObject2.getString("startMoney");
                        String description=jsonObject2.getString("description");
                        String productprincipal=jsonObject2.getString("productprincipal");
                        Money_deposit_all_item2 item2=new Money_deposit_all_item2(rates,productprincipal,startMoney,description);
                        list.add(item2);

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter=new Money_deposit_all_son_adapter(getApplicationContext(),list);
                            recyc.setAdapter(adapter);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}