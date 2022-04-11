package com.example.bank.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bank.R;
import com.example.bank.deposit.MoneyAllDepositSureActivity;
import com.example.bank.myclass.Money_deposit_all_item1;
import com.example.bank.myclass.Money_deposit_all_item2;
import com.example.bank.myclass.Money_fItem;

import java.util.ArrayList;

public class Money_deposit_all_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Money_deposit_all_item1> list = new ArrayList<>();
    private ArrayList<Money_deposit_all_item2> list1=new ArrayList<>();

    public Money_deposit_all_adapter(Context context, ArrayList<Money_deposit_all_item1> list)
    {
        this.context=context;
        this.list=list;
        this.list1=list1;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder=new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money_all_deposit_fragment,parent,false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ViewHolder vh=(ViewHolder) holder;
        vh.name.setText(list.get(position).getName());
        Log.d("adapter1",list.get(position).getName());
        Money_deposit_all_son_adapter adapter=new Money_deposit_all_son_adapter(context,list.get(position).getList());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,1,GridLayoutManager.VERTICAL,false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        vh.recyc2.setLayoutManager(gridLayoutManager);
        vh.recyc2.setAdapter(adapter);
        vh.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(context, MoneyAllDepositSureActivity.class);
                intent.putExtra("type",list.get(position).getName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,more;
        private RecyclerView recyc2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.item_money_all_deposit_ftv);
            recyc2=itemView.findViewById(R.id.item_money_all_deposit_frecyc);
            more=itemView.findViewById(R.id.item_money_all_deposit_fmore);
        }
    }
}
