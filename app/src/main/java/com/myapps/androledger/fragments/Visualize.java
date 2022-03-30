package com.myapps.androledger.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.myapps.androledger.DataBaseHelper;
import com.myapps.androledger.R;

import java.util.ArrayList;

public class Visualize extends Fragment {


    public int[] vals = DataBaseHelper.values;


    public Visualize() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_visualize, container, false);

        PieChart chart = view.findViewById(R.id.piechart);


        ArrayList<PieEntry> barEntries = new ArrayList<>();
        barEntries.add(new PieEntry(vals[0], "Food"));
        barEntries.add(new PieEntry(vals[1], "Shopping"));
        barEntries.add(new PieEntry(vals[2], "Phone"));
        barEntries.add(new PieEntry(vals[3], "Health"));
        barEntries.add(new PieEntry(vals[4], "Groceries"));
        barEntries.add(new PieEntry(vals[5], "Travel"));
        barEntries.add(new PieEntry(vals[6], "Fuel"));
        barEntries.add(new PieEntry(vals[7], "Education"));
        barEntries.add(new PieEntry(vals[8], "Electricity"));
        barEntries.add(new PieEntry(vals[9], "Bills"));
        barEntries.add(new PieEntry(vals[10], "Housing"));
        barEntries.add(new PieEntry(vals[11], "Others"));

        PieDataSet barDataSet = new PieDataSet(barEntries, "Expenses");
        PieData theData = new PieData(barDataSet);

        chart.setData(theData);

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.animateXY(1000, 1000);


        return view;
    }

}