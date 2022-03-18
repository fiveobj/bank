package com.example.bank.myclass;

import java.util.ArrayList;

public class Money_deposit_all_item1 {
    private String name;
    private ArrayList<Money_deposit_all_item2> list=new ArrayList<>();
    public Money_deposit_all_item1(String name,ArrayList<Money_deposit_all_item2> list)
    {
        this.list=list;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Money_deposit_all_item2> getList() {
        return list;
    }
}
