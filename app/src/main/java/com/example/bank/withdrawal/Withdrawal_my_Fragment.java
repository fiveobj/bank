package com.example.bank.withdrawal;

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
import com.example.bank.adapter.Money_withdrawal_my_adapter;
import com.example.bank.myclass.Money_withdrawal_my;
import com.example.bank.tool.OKhttpClass;
import com.example.bank.tool.SpaceItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Withdrawal_my_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Withdrawal_my_Fragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Withdrawal_my_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Withdrawal_my_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Withdrawal_my_Fragment newInstance(String param1, String param2) {
        Withdrawal_my_Fragment fragment = new Withdrawal_my_Fragment();
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
    private ArrayList<Money_withdrawal_my> list=new ArrayList<>();
    private Money_withdrawal_my_adapter adapter;
    private TextView total;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_withdrawal_my_, container, false);

        recyc=view.findViewById(R.id.withdrawal_my_recyc);
        total=view.findViewById(R.id.withdrawal_my_total);
        list=getdata();
        adapter=new Money_withdrawal_my_adapter(getActivity(),list);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyc.setLayoutManager(gridLayoutManager);
        recyc.addItemDecoration(new SpaceItemDecoration(0,40));
        recyc.setAdapter(adapter);
        getokhttpdata();
        return view;
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
                        Money_withdrawal_my item=new Money_withdrawal_my(cate,propertyNum,totalIncome);
                        list.add(item);

                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            total.setText(income);
                            adapter=new Money_withdrawal_my_adapter(getActivity(),list);
                            recyc.setAdapter(adapter);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private ArrayList<Money_withdrawal_my> getdata() {

        ArrayList<Money_withdrawal_my> list1=new ArrayList<>();
        list1.add(new Money_withdrawal_my("产品","本金","总收益"));


        return list1;
    }
}