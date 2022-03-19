package com.example.bank.myclass;

public class Money_deposit_my_item {
    private String name,money,profit;
    public Money_deposit_my_item(String name,String money,String profit)
    {
        this.name=name;
        this.money=money;
        this.profit=profit;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    public String getProfit() {
        return profit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }
}
