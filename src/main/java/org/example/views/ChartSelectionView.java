package org.example.views;


import org.example.views.charts.ChartBuilder;
import org.example.views.view_components.BetterButton;
import org.example.views.view_components.BetterFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


import javax.swing.*;
import java.awt.*;


public class ChartSelectionView extends BetterFrame {

    private JPanel chartPanel;
    private int currentChartIndex;
    private JFreeChart[] charts; // Store instances of different charts

    public ChartSelectionView() {
        setTitle("Chart Selection");
        setSize(600, 400);


        // Initialize chart instances
        charts = new JFreeChart[]{
//                org.example.charts.BarChartExample.createBarChart(),
                // Initialize other chart instances here
                ChartBuilder.monthlySalesChart(),
                ChartBuilder.bestSellingProductsByUnitsSoldChart(),
                ChartBuilder.bestProfitableProductsPieChart(),
                ChartBuilder.averageDeliveryTimeHistogram()
        };

        // Create a panel to hold the chart
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        displayChart(charts[currentChartIndex]);

        // Create buttons
        BetterButton leftButton = new BetterButton("<");
        leftButton.addActionListener(e -> showPreviousChart());

        BetterButton rightButton = new BetterButton(">");
        rightButton.addActionListener(e -> showNextChart());

        // Add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);

        // Add components to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(chartPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void displayChart(JFreeChart chart) {
        // Display the chart on the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);

        this.chartPanel.removeAll();
        this.chartPanel.add(chartPanel, BorderLayout.CENTER);
        this.chartPanel.revalidate();
        this.chartPanel.repaint();
    }

    private void showNextChart() {
        currentChartIndex = (currentChartIndex + 1) % charts.length;
        displayChart(charts[currentChartIndex]);
    }

    private void showPreviousChart() {
        currentChartIndex = (currentChartIndex - 1 + charts.length) % charts.length;
        displayChart(charts[currentChartIndex]);
    }


}
