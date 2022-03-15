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
import com.example.bank.myclass.Money_fItem;

import java.util.ArrayList;

public class Money_fItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Money_fItem> list=new ArrayList<Money_fItem>();

    public Money_fItemAdapter(Context context,ArrayList<Money_fItem> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder=new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money_fragment,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder) holder;
        vh.name.setText(list.get(position).getName());
        vh.rate.setText(list.get(position).getRate());
        vh.time.setText(list.get(position).getTime());
        vh.money.setText(list.get(position).getMoney());
        if (position==0)vh.line.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,rate,time,money;
        private ImageView line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.item_money_fname);
            rate=itemView.findViewById(R.id.item_money_frate);
            time=itemView.findViewById(R.id.item_money_ftime);
            money=itemView.findViewById(R.id.item_money_fmoney);
            line=itemView.findViewById(R.id.item_money_fline);
        }
    }
}
