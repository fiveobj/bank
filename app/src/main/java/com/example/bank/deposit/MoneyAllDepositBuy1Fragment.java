package com.example.bank.deposit;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.os.TokenWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView rate,time,moneystart,income;
    private EditText money;
    private String flowId,productid;
    private Float xi,moneys,willincome;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_money_all_deposit_buy1, container, false);

        next=view.findViewById(R.id.deposit_all_buy1_next);
        rate=view.findViewById(R.id.all_deposit_buy1_rate);
        time=view.findViewById(R.id.all_deposit_buy1_time);
        moneystart=view.findViewById(R.id.all_deposit_buy1_money);
        money=view.findViewById(R.id.all_deposit_buy1_monry);
        income=view.findViewById(R.id.all_deposit_buy1_income);
        if (getActivity().getIntent().getStringExtra("name")!=null)
        {
            rate.setText(getActivity().getIntent().getStringExtra("rate"));
            time.setText(getActivity().getIntent().getStringExtra("time"));
            moneystart.setText(getActivity().getIntent().getStringExtra("startmoney")+"元起存");
            money.setHint(getActivity().getIntent().getStringExtra("startmoney")+"起");
            flowId=getActivity().getIntent().getStringExtra("flowid");
            productid=getActivity().getIntent().getStringExtra("productid");
            xi=Float.parseFloat(getActivity().getIntent().getStringExtra("xi"));
        }

        money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                moneys=Float.parseFloat(s.toString());
                if (moneys>666666)
                {
                    Toast.makeText(getActivity(),"超出账户余额",Toast.LENGTH_SHORT).show();
                }
                else {
                    willincome=moneys*xi;
                    income.setText(willincome.toString());
                }

            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneys!=null)
                {
                    MoneyAllDepositBuy2Fragment fragment=new MoneyAllDepositBuy2Fragment();
                    fragment.setMoney(moneys.toString());
                    fragment.setIncomes(willincome.toString());
                    getActivity().getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.deposit_buy_relative,fragment)
                            .addToBackStack(null)
                            .commit();
                }
                else Toast.makeText(getActivity(),"请输入正确的金额",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}