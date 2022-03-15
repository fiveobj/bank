package com.example.bank.myclass;

public class Money_fItem {
    private String name,rate,time,money;

    public Money_fItem(String name,String rate,String money,String time)
    {
        this.name=name;
        this.time=time;
        this.money=money;
        this.rate=rate;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    public String getRate() {
        return rate;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
