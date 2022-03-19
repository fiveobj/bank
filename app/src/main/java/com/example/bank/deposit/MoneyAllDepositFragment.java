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
import com.example.bank.tool.SpaceItemDecoration;

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
    private ArrayList<Money_deposit_all_item2> list3=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_money_all_deposit, container, false);
        deposit_all_recyc=view.findViewById(R.id.fragment_money_all_recyc);

        list2.add(new Money_deposit_all_item2("111","1111","1111","1111"));
        list2.add(new Money_deposit_all_item2("111","1111","1111","1111"));
        list2.add(new Money_deposit_all_item2("111","1111","1111","1111"));
        list3.add(new Money_deposit_all_item2("222222","1111","1111","1111"));
        list3.add(new Money_deposit_all_item2("112221","1111","1111","1111"));
        list3.add(new Money_deposit_all_item2("112221","1111","1111","1111"));
        list1.add(new Money_deposit_all_item1("定期存款",list2));
        list1.add(new Money_deposit_all_item1("活期存款",list3));
        list1.add(new Money_deposit_all_item1("定活两便",list2));
        adapter=new Money_deposit_all_adapter(getActivity(),list1);
        Log.d("list1",list1.get(0).getName().toString());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 1, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deposit_all_recyc.setLayoutManager(gridLayoutManager);
        deposit_all_recyc.addItemDecoration(new SpaceItemDecoration(0,0));
        deposit_all_recyc.setAdapter(adapter);




        return view;
    }
}