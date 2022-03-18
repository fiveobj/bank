package com.example.bank.myclass;

public class Money_deposit_all_item2 {
    private String rate,time,moneystart,brief;
    public Money_deposit_all_item2(String rate, String time, String moneystart, String brief)
    {
        this.brief=brief;
        this.moneystart=moneystart;
        this.time=time;
        this.rate=rate;
    }

    public String getTime() {
        return time;
    }

    public String getRate() {
        return rate;
    }

    public String getBrief() {
        return brief;
    }

    public String getMoneystart() {
        return moneystart;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setMoneystart(String moneystart) {
        this.moneystart = moneystart;
    }
}
