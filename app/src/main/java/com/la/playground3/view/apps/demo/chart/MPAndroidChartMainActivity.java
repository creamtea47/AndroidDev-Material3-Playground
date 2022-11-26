package com.la.playground3.view.apps.demo.chart;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.snackbar.Snackbar;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.databinding.ActivityMpandroidChartMainBinding;

import java.util.ArrayList;

public class MPAndroidChartMainActivity extends CustomActivity {

    private final int nodesNum = 10;
    private ActivityMpandroidChartMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMpandroidChartMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        initToolBar();
        initFab();
        initChart();
    }

    /**
     * Initialize the toolbar
     */
    private void initToolBar() {
        binding.toolbar.setNavigationOnClickListener(view -> finish());
    }

    /**
     * 初始化图表
     */
    private void initChart() {
        initLineChart();
        initBarChart();
    }

    /**
     * 初始化折线图
     */
    private void initLineChart() {
        LineDataSet lineDataSet = new LineDataSet(lineChartDataValues(), "折线图数据");
        lineDataSet.setColors(Color.parseColor("#D0BCFF"));
        lineDataSet.setCircleColor(Color.parseColor("#D0BCFF"));
        binding.include.lineChart.getDescription().setText("折线图");
        binding.include.lineChart.setData(new LineData(lineDataSet));
    }

    /**
     * 初始化柱状图
     */
    private void initBarChart() {
        BarDataSet barDataSet = new BarDataSet(barChartDataValues(), "柱状图数据");
        barDataSet.setColors(Color.parseColor("#D0BCFF"));
        binding.include.barChart.getDescription().setText("柱状图");
        binding.include.barChart.setData(new BarData(barDataSet));
    }

    /**
     * 初始化折线图数据
     *
     * @return 折线图数据
     */
    private ArrayList<Entry> lineChartDataValues() {
        ArrayList<Entry> dataValues = new ArrayList<Entry>();
        for (int i = 0; i < nodesNum; i++) {
            dataValues.add(new Entry(i, (float) (Math.random() * 100)));
        }
        return dataValues;
    }

    /**
     * 初始化柱状图数据
     *
     * @return 柱状图数据
     */
    private ArrayList<BarEntry> barChartDataValues() {
        ArrayList<BarEntry> dataValues = new ArrayList<BarEntry>();
        for (int i = 0; i < nodesNum; i++) {
            dataValues.add(new BarEntry(i, (float) (Math.random() * 100)));
        }
        return dataValues;
    }

    /**
     * Initialize the floating action button
     */
    private void initFab() {
        binding.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }
}