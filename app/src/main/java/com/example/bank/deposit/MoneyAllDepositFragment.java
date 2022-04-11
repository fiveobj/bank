package com.example.bank.deposit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bank.R;
import com.example.bank.adapter.Money_deposit_all_adapter;
import com.example.bank.myclass.Money_deposit_all_item1;
import com.example.bank.myclass.Money_deposit_all_item2;
import com.example.bank.tool.OKhttpClass;
import com.example.bank.tool.SpaceItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoneyAllDepositFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoneyAllDepositFragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoneyAllDepositFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoneyAllDepositFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoneyAllDepositFragment newInstance(String param1, String param2) {
        MoneyAllDepositFragment fragment = new MoneyAllDepositFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView deposit_all_recyc;
    private Money_deposit_all_adapter adapter;
    private ArrayList<Money_deposit_all_item1> list1=new ArrayList<>();
    private ArrayList<Money_deposit_all_item2> list2=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_money_all_deposit, container, false);
        deposit_all_recyc=view.findViewById(R.id.fragment_money_all_recyc);

        /*list2.add(new Money_deposit_all_item2("111","1111","1111","1111"));
        list2.add(new Money_deposit_all_item2("111","1111","1111","1111"));
        list2.add(new Money_deposit_all_item2("111","1111","1111","1111"));
        list3.add(new Money_deposit_all_item2("222222","1111","1111","1111"));
        list3.add(new Money_deposit_all_item2("112221","1111","1111","1111"));
        list3.add(new Money_deposit_all_item2("112221","1111","1111","1111"));
        list1.add(new Money_deposit_all_item1("定期存款",list2));
        list1.add(new Money_deposit_all_item1("活期存款",list3));
        list1.add(new Money_deposit_all_item1("定活两便",list2));*/
        adapter=new Money_deposit_all_adapter(getActivity(),list1);
        //Log.d("list1",list1.get(0).getName().toString());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 1, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deposit_all_recyc.setLayoutManager(gridLayoutManager);
        deposit_all_recyc.addItemDecoration(new SpaceItemDecoration(0,10));
        deposit_all_recyc.setAdapter(adapter);


        getdata();

        return view;
    }

    private void getdata()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OKhttpClass oKhttpClass=new OKhttpClass();
                String result=oKhttpClass.ban2("1");
                Log.d("bank2",result);
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    String data=jsonObject.getString("data");
                    JSONArray jsonArray=new JSONArray(data);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        Log.d("bank2-data",jsonArray.get(i).toString());
                        String ll1=jsonArray.get(i).toString();
                        JSONObject jsonObject1=new JSONObject(ll1);
                        String name=jsonObject1.getString("type");
                        String product=jsonObject1.getString("product");
                        JSONArray jsonArray1=new JSONArray(product);
                        Log.d("bank2-name",name);
                        //list2.clear();
                        ArrayList<Money_deposit_all_item2> list3=new ArrayList<>();
                        for (int j=0;j<jsonArray1.length();j++)
                        {
                            Log.d("bank2-data2",jsonArray1.get(j).toString());
                            String data1= jsonArray1.get(j).toString();
                            JSONObject jsonObject2=new JSONObject(data1);
                            String name1=jsonObject2.getString("description");
                            String time=jsonObject2.getString("productprincipal");
                            String startmoney=jsonObject2.getString("startMoney")+"元起存";
                            String rate=jsonObject2.getString("rates")+"%";
                            Money_deposit_all_item2 item2=new Money_deposit_all_item2(rate,time,startmoney,name1);
                            list3.add(item2);

                        }
                        Money_deposit_all_item1 item1=new Money_deposit_all_item1(name,list3);
                        list1.add(item1);

                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter=new Money_deposit_all_adapter(getActivity(),list1);
                            deposit_all_recyc.setAdapter(adapter);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}