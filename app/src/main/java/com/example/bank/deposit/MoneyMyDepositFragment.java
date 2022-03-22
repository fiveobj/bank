package com.example.bank.deposit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bank.R;
import com.example.bank.adapter.Money_deposit_my_adapter;
import com.example.bank.adapter.Money_withdrawal_my_adapter;
import com.example.bank.myclass.Money_deposit_my_item;
import com.example.bank.tool.SpaceItemDecoration;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_money_my_deposit, container, false);


        recyc=view.findViewById(R.id.money_my_deposit_frecyc);
        list=getData();
        adapter=new Money_deposit_my_adapter(getActivity(),list);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyc.setLayoutManager(gridLayoutManager);
        recyc.addItemDecoration(new SpaceItemDecoration(0,20));
        recyc.setAdapter(adapter);


        return view;
    }

    private ArrayList<Money_deposit_my_item> getData() {

        ArrayList<Money_deposit_my_item> list1=new ArrayList<>();
        list1.add(new Money_deposit_my_item("定期存款","3333.00","+333.00"));
        list1.add(new Money_deposit_my_item("定期存款","3333.00","+333.00"));
        list1.add(new Money_deposit_my_item("定期存款","3333.00","+333.00"));
        list1.add(new Money_deposit_my_item("定期存款","3333.00","+333.00"));
        return list1;
    }
}