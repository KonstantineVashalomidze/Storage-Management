package org.example.views;


import org.example.views.charts.ChartBuilder;
import org.example.views.view_components.BetterButton;
import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.CustomDatePickerPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class ChartSelectionView extends JPanel {

    private JPanel chartPanel, buttonPanel;
    private int currentChartIndex;
    private BetterButton fromDateButton, toDateButton;
    private JFreeChart[] charts; // Store instances of different charts


    public ChartSelectionView() {


        // Initialize chart instances
        charts = new JFreeChart[]{
                // Initialize other chart instances here
                ChartBuilder.monthlySalesChart(),
                ChartBuilder.bestSellingProductsByUnitsSoldChart(),
                ChartBuilder.bestProfitableProductsPieChart(),
                ChartBuilder.averageDeliveryTimeHistogram()
        };

        // Add buttons to a panel
        buttonPanel = new JPanel();

        fromDateButton = new BetterButton("From");
        toDateButton = new BetterButton("To");


        // Create a panel to hold the chart
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        displayChart(charts[currentChartIndex]);

        // Create buttons
        BetterButton leftButton = new BetterButton("<");
        leftButton.addActionListener(e -> showPreviousChart());

        BetterButton rightButton = new BetterButton(">");
        rightButton.addActionListener(e -> showNextChart());



        // Make layout to flow layout where buttons are added
        buttonPanel.setLayout(new FlowLayout());

        // Add buttons to this buttonPanel
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        buttonPanel.add(fromDateButton);
        buttonPanel.add(toDateButton);



        // Add components to the frame
        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);




    }


    private void displayChart(JFreeChart chart)
    {
        // Display the chart on the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);


        if (currentChartIndex == 0)
        {
            if (buttonPanel.getComponents().length != 0)
            {
                buttonPanel.add(fromDateButton);
                buttonPanel.add(toDateButton);
            }
            var datePicker = new CustomDatePickerPanel();
            fromDateButton.addActionListener((e) -> {
                add(datePicker);
            });
            toDateButton.addActionListener((e) -> {

            });


        }
        else {
            buttonPanel.remove(fromDateButton);
            buttonPanel.remove(toDateButton);

        }

        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);

        buttonPanel.revalidate();
        buttonPanel.repaint();

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
