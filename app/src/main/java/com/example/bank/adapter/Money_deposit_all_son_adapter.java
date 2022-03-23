package com.example.bank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bank.R;
import com.example.bank.myclass.Money_deposit_all_item2;

import java.util.ArrayList;

public class Money_deposit_all_son_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Money_deposit_all_item2> list=new ArrayList<>();

    public Money_deposit_all_son_adapter(Context context, ArrayList<Money_deposit_all_item2> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_money_all_deposit_fragment1,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 200));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder) holder;
        vh.rate.setText(list.get(position).getRate());
        vh.time.setText(list.get(position).getTime());
        vh.money.setText(list.get(position).getMoneystart());
        vh.brief.setText(list.get(position).getBrief());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView rate,time,money,brief;
        private ImageView button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rate=itemView.findViewById(R.id.item_money_all_deposit_f1rate);
            time=itemView.findViewById(R.id.item_money_all_deposit_f1time);
            money=itemView.findViewById(R.id.item_money_all_deposit_f1money);
            brief=itemView.findViewById(R.id.item_money_all_deposit_f1brief);
            button=itemView.findViewById(R.id.item_money_all_deposit_f1bue);
        }
    }
}
