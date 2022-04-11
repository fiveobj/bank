package com.example.bank.withdrawal;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ArrayRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bank.R;
import com.example.bank.adapter.Money_withdrawal_all_adapter;
import com.example.bank.myclass.Money_withdrawal_all;
import com.example.bank.tool.OKhttpClass;
import com.example.bank.tool.SpaceItemDecoration;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private RecyclerView recyc;
    private Money_withdrawal_all_adapter adapter;
    private ArrayList<Money_withdrawal_all> list=new ArrayList<>();
    private int[] vieww=new int[]{R.mipmap.withdrawal_all_view1,R.mipmap.withdrawal_all_view2,R.mipmap.withdrawal_all_view3,R.mipmap.withdrawal_all_view4,R.mipmap.withdrawal_all_view5};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_withdrawal_all_, container, false);
        chart=view.findViewById(R.id.withdrawal_chart);
        recyc=view.findViewById(R.id.withdrawal_all_recyc);
        list=getData();
        adapter=new Money_withdrawal_all_adapter(getActivity(),list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 1, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyc.setLayoutManager(gridLayoutManager);
        recyc.addItemDecoration(new SpaceItemDecoration(0,80));
        recyc.setAdapter(adapter);
        initdata();

        return view;
    }

    private ArrayList<Money_withdrawal_all> getData() {
        ArrayList<Money_withdrawal_all> list1 = new ArrayList<>();
        list1.add(new Money_withdrawal_all(R.mipmap.withdrawal_all_view1, "定期存款", "1735"));
        list1.add(new Money_withdrawal_all(R.mipmap.withdrawal_all_view2, "活期存款", "1735"));
        list1.add(new Money_withdrawal_all(R.mipmap.withdrawal_all_view3, "定活两便", "1735"));
        list1.add(new Money_withdrawal_all(R.mipmap.withdrawal_all_view4, "通知存款", "1735"));
        list1.add(new Money_withdrawal_all(R.mipmap.withdrawal_all_view5, "大额存单", "1735"));
        return list1;
    }

    private void initdata(){

        colors=new ArrayList<Integer>();
        colors.add(Color.rgb(255,187,0));
        colors.add(Color.rgb(255,163,51));
        colors.add(Color.rgb(250,100,0));
        colors.add(Color.rgb(45,47,60));
        colors.add(Color.rgb(255,51,51));

        new Thread(new Runnable() {
            @Override
            public void run() {
                OKhttpClass oKhttpClass=new OKhttpClass();
                String result=oKhttpClass.ban6("1");
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    String data=jsonObject.getString("data");
                    JSONArray jsonArray=new JSONArray(data);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        String data1=jsonArray.get(i).toString();
                        JSONObject jsonObject1=new JSONObject(data1);
                        String propertyType=jsonObject1.getString("propertyType");
                        String sumtotal=jsonObject1.getString("sumtotal");
                        Money_withdrawal_all item=new Money_withdrawal_all(vieww[i],propertyType,sumtotal);
                        list.add(item);
                    }
                    xContents=new ArrayList<String>();
                   /* xContents.add("定期存款");
                    xContents.add("活期存款");
                    xContents.add("定活两便");
                    xContents.add("通知存款");
                    xContents.add("大额订单");*/
                    for (int i=0;i<list.size();i++)
                    {
                        xContents.add(list.get(i).getName());
                    }

                    float[] m=new float[]{121,141,432,233,123};
                    /*float m1=121;
                    float m2=141;
                    float m3=432;
                    float m4=233;
                    float m5=123;*/

                    yContents=new ArrayList<>();
                   /* yContents.add(new PieEntry(m1,"定期存款"));
                    yContents.add(new PieEntry(m2,"活期存款"));
                    yContents.add(new PieEntry(m3,"定活两便"));
                    yContents.add(new PieEntry(m4,"通知存款"));
                    yContents.add(new PieEntry(m5,"大额订单"));*/
                    for (int i=0;i<list.size();i++)
                    {
                        yContents.add(new PieEntry(m[i],list.get(i).getName()));
                    }


                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter=new Money_withdrawal_all_adapter(getActivity(),list);
                            recyc.setAdapter(adapter);
                            PieData pieData=getPieData(4,100);
                            showChart(chart,pieData);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


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
        pieChart.setHoleRadius(65f);
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
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDrawEntryLabels(false);
        //饼状图中间的文字
        pieChart.setCenterText(generateCenterSpannableText());
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

    protected SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("总资产（元）50000");
        s.setSpan(new RelativeSizeSpan(1.3f), 0, s.length(), 0);
        //s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        //s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        //s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        //s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        //s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }

}