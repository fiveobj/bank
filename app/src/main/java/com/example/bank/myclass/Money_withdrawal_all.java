package com.example.bank.myclass;

public class Money_withdrawal_all {
    private int view;
    private String name,money;

    public Money_withdrawal_all(int view,String name,String money)
    {
        this.money=money;
        this.name=name;
        this.view=view;
    }

    public String getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getView() {
        return view;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setView(int view) {
        this.view = view;
    }
}
