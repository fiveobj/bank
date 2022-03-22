package com.example.bank.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bank.R;
import com.example.bank.myclass.Money_withdrawal_my;

import java.util.ArrayList;

public class Money_withdrawal_my_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Money_withdrawal_my> list=new ArrayList<>();

    public Money_withdrawal_my_adapter(Context context,ArrayList<Money_withdrawal_my> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder=new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money_my_withdrawal_fragment,parent,false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder) holder;
        vh.date.setText(list.get(position).getDate());
        vh.principal.setText(list.get(position).getPrincipal());
        vh.yesterday_earn.setText(list.get(position).getYesterday_earn());
        vh.sum_earn.setText(list.get(position).getSum_earn());
        if (position==0){
            vh.sum_earn.setTextColor(Color.parseColor("#484E54"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView date,principal,yesterday_earn,sum_earn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.item_money_my_withdrawal_tv1);
            principal=itemView.findViewById(R.id.item_money_my_withdrawal_tv2);
            yesterday_earn=itemView.findViewById(R.id.item_money_my_withdrawal_tv3);
            sum_earn=itemView.findViewById(R.id.item_money_my_withdrawal_tv4);
        }
    }
}
