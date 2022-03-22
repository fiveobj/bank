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
import com.example.bank.myclass.Money_deposit_my_item;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Money_deposit_my_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Money_deposit_my_item> list=new ArrayList<>();

    public Money_deposit_my_adapter(Context context,ArrayList<Money_deposit_my_item> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder vh=new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money_my_deposit_fragment,parent,false));

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder) holder;
        vh.name.setText(list.get(position).getName());
        vh.money.setText(list.get(position).getMoney());
        vh.profile.setText(list.get(position).getProfit());
        if (position==list.size()-1)
        {
            vh.line.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name,money,profile;
        private ImageView line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            line=itemView.findViewById(R.id.item_money_my_deposit_fline);
            name=itemView.findViewById(R.id.item_money_my_deposit_fname);
            money=itemView.findViewById(R.id.item_money_my_deposit_fmoney);
            profile=itemView.findViewById(R.id.item_money_my_deposit_fprofile);
        }
    }
}
