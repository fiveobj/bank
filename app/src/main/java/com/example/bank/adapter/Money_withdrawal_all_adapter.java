package com.example.bank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bank.R;
import com.example.bank.myclass.Money_withdrawal_all;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Money_withdrawal_all_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Money_withdrawal_all> list=new ArrayList<>();

    public Money_withdrawal_all_adapter(Context context,ArrayList<Money_withdrawal_all> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder=new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money_all_withdrawal_fragment,parent,false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder) holder;
        vh.name.setText(list.get(position).getName());
        vh.money.setText(list.get(position).getMoney());
        vh.view.setImageResource(list.get(position).getView());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView view,more;
        private TextView name,money;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.item_money_all_withdrawal_view);
            more=itemView.findViewById(R.id.item_money_all_withdrawal_more);
            name=itemView.findViewById(R.id.item_money_all_withdrawal_name);
            money=itemView.findViewById(R.id.item_money_all_withdrawal_money);
        }
    }
}
