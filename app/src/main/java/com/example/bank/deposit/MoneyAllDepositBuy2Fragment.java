package com.example.bank.deposit;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.bank.R;
import com.example.bank.tool.OKhttpClass;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.time.LocalDate;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoneyAllDepositBuy2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoneyAllDepositBuy2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoneyAllDepositBuy2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoneyAllDepositBuy2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoneyAllDepositBuy2Fragment newInstance(String param1, String param2) {
        MoneyAllDepositBuy2Fragment fragment = new MoneyAllDepositBuy2Fragment();
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

    private String money,incomes;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIncomes() {
        return incomes;
    }

    public void setIncomes(String incomes) {
        this.incomes = incomes;
    }

    private TextView rate,name,time,income,moneys;
    private String flowId,productid;
    private RelativeLayout buy;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_money_all_deposit_buy2, container, false);

        rate=view.findViewById(R.id.all_deposit_buy2_rate);
        name=view.findViewById(R.id.all_deposit_buy2_name);
        time=view.findViewById(R.id.all_deposit_buy2_time);
        income=view.findViewById(R.id.all_deposit_buy2_income);
        moneys=view.findViewById(R.id.all_deposit_buy2_money);
        buy=view.findViewById(R.id.all_deposit_buy2_buy);
        moneys.setText("￥"+money);
        if (getActivity().getIntent().getStringExtra("name")!=null)
        {
            rate.setText(getActivity().getIntent().getStringExtra("rate"));
            time.setText(getActivity().getIntent().getStringExtra("time"));
            name.setText(getActivity().getIntent().getStringExtra("name"));
            income.setText(incomes);
            flowId=getActivity().getIntent().getStringExtra("flowid");
            productid=getActivity().getIntent().getStringExtra("productid");
        }


        buy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                View view1=getLayoutInflater().inflate(R.layout.pay_dialog_layout,null);
                final EditText editText=(EditText) view1.findViewById(R.id.dialog_pay);
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        //.setIcon(R.mipmap.icon)//设置标题的图片
                        .setTitle("请输入密码:")//设置对话框的标题
                        .setView(view1)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String content = editText.getText().toString();
                                if (content.equals("123456"))
                                {

                                    pay();
                                }
                                else
                                Toast.makeText(getActivity(),"密码错误",Toast.LENGTH_SHORT).show();

                            }
                        }).create();
                dialog.show();
            }
        });

        return view;
    }

    private void pay()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OKhttpClass oKhttpClass=new OKhttpClass();
                String result= null;
                String status=null;
                String msg=null;
                try {
                    result = oKhttpClass.ban7(flowId,productid,"1",money);
                    JSONObject jsonObject=new JSONObject(result);
                    status=jsonObject.getString("code");
                    msg=jsonObject.getString("message");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("ban7",result);
                String finalStatus = status;
                String finalMsg = msg;

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), finalMsg,Toast.LENGTH_SHORT).show();
                        //dialog.dismiss();
                    }
                });
            }
        }).start();
    }
}