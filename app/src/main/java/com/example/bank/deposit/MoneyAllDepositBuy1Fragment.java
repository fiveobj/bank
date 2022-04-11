package com.example.bank.deposit;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.bank.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoneyAllDepositBuy1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoneyAllDepositBuy1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoneyAllDepositBuy1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoneyAllDepositBuy1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoneyAllDepositBuy1Fragment newInstance(String param1, String param2) {
        MoneyAllDepositBuy1Fragment fragment = new MoneyAllDepositBuy1Fragment();
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

    private RelativeLayout next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_money_all_deposit_buy1, container, false);

        next=view.findViewById(R.id.deposit_all_buy1_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().getFragmentManager()
                       .beginTransaction()
                       .replace(R.id.deposit_buy_relative,new MoneyAllDepositBuy2Fragment())
                       .addToBackStack(null)
                       .commit();
            }
        });
        return view;
    }
}