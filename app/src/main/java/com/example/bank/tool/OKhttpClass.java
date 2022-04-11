package com.example.bank.tool;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKhttpClass {
    private static OkHttpClient okHttpClient= new OkHttpClient.Builder().connectTimeout(160000, TimeUnit.MILLISECONDS).build();
    private String baseurls="http://192.168.43.188:8086/api/";

    //理财
    public String ban1(String uid){
        Request.Builder builder=new Request.Builder().url(baseurls+"licai/1");
        builder.method("GET",null);
        Request request=builder.build();
        try(Response response=okHttpClient.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ban1-e",e.toString());
        }
        return "FW";
    }

    //全部存款
    public String ban2(String uid){
        Request.Builder builder=new Request.Builder().url(baseurls+"allproduct");
        builder.method("GET",null);
        Request request=builder.build();
        try(Response response=okHttpClient.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ban2-e",e.toString());
        }
        return "FW";
    }

    //具体存款
    public String ban3(String type){
        Request.Builder builder=new Request.Builder().url(baseurls+"allproduct/"+type);
        builder.method("GET",null);
        Request request=builder.build();
        try(Response response=okHttpClient.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ban3-e",e.toString());
        }
        return "FW";
    }

    //我的存款
    public String ban4(String uid){
        Request.Builder builder=new Request.Builder().url(baseurls+"myproduct/1");
        builder.method("GET",null);
        Request request=builder.build();
        try(Response response=okHttpClient.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ban4-e",e.toString());
        }
        return "FW";
    }


    //我的取款
    public String ban5(String uid){
        Request.Builder builder=new Request.Builder().url(baseurls+"qukuan/1");
        builder.method("GET",null);
        Request request=builder.build();
        try(Response response=okHttpClient.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ban5-e",e.toString());
        }
        return "FW";
    }

    //账户总览
    public String ban6(String uid){
        Request.Builder builder=new Request.Builder().url(baseurls+"zhanghuzonglan/1");
        builder.method("GET",null);
        Request request=builder.build();
        try(Response response=okHttpClient.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("ban6-e",e.toString());
        }
        return "FW";
    }
}
