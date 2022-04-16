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
import android.widget.TextView;

import com.example.bank.R;
import com.example.bank.adapter.Money_deposit_my_adapter;
import com.example.bank.adapter.Money_withdrawal_my_adapter;
import com.example.bank.myclass.Money_deposit_my_item;
import com.example.bank.myclass.Money_withdrawal_my;
import com.example.bank.tool.OKhttpClass;
import com.example.bank.tool.SpaceItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoneyMyDepositFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoneyMyDepositFragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoneyMyDepositFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoneyMyDepositFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoneyMyDepositFragment newInstance(String param1, String param2) {
        MoneyMyDepositFragment fragment = new MoneyMyDepositFragment();
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

    private RecyclerView recyc;
    private ArrayList<Money_deposit_my_item> list=new ArrayList<>();
    private Money_deposit_my_adapter adapter;
    private TextView total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_money_my_deposit, container, false);

        total=view.findViewById(R.id.money_my_deposit_total);
        recyc=view.findViewById(R.id.money_my_deposit_frecyc);
        list=getData();
        adapter=new Money_deposit_my_adapter(getActivity(),list);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyc.setLayoutManager(gridLayoutManager);
        recyc.addItemDecoration(new SpaceItemDecoration(0,20));
        recyc.setAdapter(adapter);

        getokhttpdata();
        return view;
    }

    private ArrayList<Money_deposit_my_item> getData() {

        ArrayList<Money_deposit_my_item> list1=new ArrayList<>();

        return list1;
    }

    private void getokhttpdata()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OKhttpClass oKhttpClass=new OKhttpClass();
                String result=oKhttpClass.ban4("1");
                Log.d("ban4",result);
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    String data=jsonObject.getString("data");
                    JSONObject jsonObject1=new JSONObject(data);
                    String income=jsonObject1.getString("Income");
                    String category=jsonObject1.getString("category");
                    JSONArray jsonArray=new JSONArray(category);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        String data1=jsonArray.get(i).toString();
                        Log.d("ban4-data1",data1);

                        JSONObject jsonObject2=new JSONObject(data1);
                        String cate=jsonObject2.getString("category");
                        String propertyNum=jsonObject2.getString("propertyNum");
                        String totalIncome=jsonObject2.getString("totalIncome");
                        Money_deposit_my_item item=new Money_deposit_my_item(cate,propertyNum,totalIncome);
                        list.add(item);

                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            total.setText(income);
                            adapter=new Money_deposit_my_adapter(getActivity(),list);
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