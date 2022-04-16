package com.example.bank.myclass;

public class Money_deposit_all_item2 {
    private String rate,time,moneystart,brief;//比率、存期、起存、简介
    private String productid,flowid;
    private String type,xi;
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

    public String getFlowid() {
        return flowid;
    }

    public String getProductid() {
        return productid;
    }

    public void setFlowid(String flowid) {
        this.flowid = flowid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXi() {
        return xi;
    }

    public void setXi(String xi) {
        this.xi = xi;
    }
}
