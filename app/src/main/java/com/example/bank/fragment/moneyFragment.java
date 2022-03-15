package com.example.bank.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bank.R;
import com.example.bank.adapter.Money_fItemAdapter;
import com.example.bank.myclass.Money_fItem;
import com.example.bank.tool.SpaceItemDecoration;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link moneyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class moneyFragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public moneyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment moneyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static moneyFragment newInstance(String param1, String param2) {
        moneyFragment fragment = new moneyFragment();
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

    private RecyclerView deposit_recyc;
    private Money_fItemAdapter adapter;
    private ArrayList<Money_fItem> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_money, container, false);
        deposit_recyc=view.findViewById(R.id.fragment_money_recyclerView);
        initView(view);
        return view;
    }

    private void initView(View view)
    {

        getData();
        adapter=new Money_fItemAdapter(this.getActivity(),list);

        //3列展示
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deposit_recyc.setLayoutManager(gridLayoutManager);
        deposit_recyc.addItemDecoration(new SpaceItemDecoration(6,45));
        deposit_recyc.setAdapter(adapter);

    }

    private void getData() {
        ArrayList<Money_fItem> list1=new ArrayList<>();
        list.add(new Money_fItem("定活两便","2.1%","50元起存","不定期"));
        list.add(new Money_fItem("定活两便","2.1%","50元起存","不定期"));
        list.add(new Money_fItem("定活两便","2.1%","50元起存","不定期"));
        //return list1;

    }
}