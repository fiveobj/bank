package com.example.bank.myclass;

public class Money_withdrawal_my {
    private String date,principal,yesterday_earn,sum_earn;

    public Money_withdrawal_my(String date,String principal,String yesterday_earn,String sum_earn)
    {
        this.date=date;
        this.principal=principal;
        this.yesterday_earn=yesterday_earn;
        this.sum_earn=sum_earn;
    }

    public String getDate() {
        return date;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getSum_earn() {
        return sum_earn;
    }

    public String getYesterday_earn() {
        return yesterday_earn;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void setSum_earn(String sum_earn) {
        this.sum_earn = sum_earn;
    }

    public void setYesterday_earn(String yesterday_earn) {
        this.yesterday_earn = yesterday_earn;
    }
}
