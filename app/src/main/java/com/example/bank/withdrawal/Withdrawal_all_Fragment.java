package com.example.bank.withdrawal;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ArrayRes;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bank.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Withdrawal_all_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Withdrawal_all_Fragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Withdrawal_all_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Withdrawal_all_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Withdrawal_all_Fragment newInstance(String param1, String param2) {
        Withdrawal_all_Fragment fragment = new Withdrawal_all_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private PieChart chart;
    private ArrayList<Integer> colors;
    private ArrayList<String> xContents;
    private ArrayList<PieEntry> yContents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_withdrawal_all_, container, false);
        chart=view.findViewById(R.id.withdrawal_chart);
        initdata();
        PieData pieData=getPieData(4,100);
        showChart(chart,pieData);
        return view;
    }

    private void initdata(){

        colors=new ArrayList<Integer>();
        colors.add(Color.rgb(255,187,0));
        colors.add(Color.rgb(255,163,51));
        colors.add(Color.rgb(250,100,0));
        colors.add(Color.rgb(45,47,60));
        colors.add(Color.rgb(255,51,51));

        xContents=new ArrayList<String>();
        xContents.add("定期存款");
        xContents.add("活期存款");
        xContents.add("定活两便");
        xContents.add("通知存款");
        xContents.add("大额订单");

        float m1=121;
        float m2=41;
        float m3=432;
        float m4=633;
        float m5=23;

        yContents=new ArrayList<>();
        yContents.add(new PieEntry(m1,0));
        yContents.add(new PieEntry(m2,1));
        yContents.add(new PieEntry(m3,2));
        yContents.add(new PieEntry(m4,3));
        yContents.add(new PieEntry(m5,4));


    }

    private PieData getPieData(int count, float range){

        PieDataSet pieDataSet= new PieDataSet(yContents,null);
        //设置饼状图之间的距离
        pieDataSet.setSliceSpace(0f);
        //设置饼状图之间的颜色
        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        // 选中态多出的长度
        pieDataSet.setSelectionShift(px);
        PieData pieData = new PieData(pieDataSet);
        return pieData;
    }

    private void showChart(PieChart pieChart, PieData pieData) {
//            pieChart.setHoleColorTransparent(true);
        //半径
        pieChart.setHoleRadius(60f);
        //半透明圈
        pieChart.setTransparentCircleRadius(64f);
//            pieChart.setHoleRadius(0);  //实心圆
        //添加右下角备注
        //pieChart.setDescription();
        //饼状图中间可以添加文字
        pieChart.setDrawCenterText(true);
        pieChart.setDrawHoleEnabled(true);
        //初始旋转角度
        pieChart.setRotationAngle(90);
        //可以手动旋转
        pieChart.setRotationEnabled(true);
        //显示成百分比
        pieChart.setUsePercentValues(false);
        //饼状图中间的文字
        pieChart.setCenterText("总资产（元）50000");
        //设置数据
        pieChart.setData(pieData);

        //设置比例图
        Legend mLegend = pieChart.getLegend();
//          mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
//          mLegend.setForm(Legend.LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);
        //设置动画
        pieChart.animateXY(1000, 1000);
//        	pieChart.spin(2000, 0, 360);
    }

}