package org.example.views.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class ChartBuilder {

    // Sample methods to create different types of charts

    public static JFreeChart buildBarChart(CategoryDataset dataset, String title, String categoryAxisLabel, String valueAxisLabel) {
        return ChartFactory.createBarChart(
                title,
                categoryAxisLabel,
                valueAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    public static JFreeChart buildPieChart(DefaultPieDataset dataset, String title) {
        return ChartFactory.createPieChart(
                title,
                dataset,
                true,
                true,
                false
        );
    }




    public static CategoryDataset createSampleBarDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Populate dataset with values from your database
        dataset.addValue(100, "Category 1", "Product 1");
        dataset.addValue(150, "Category 1", "Product 2");
        // Add more data...
        return dataset;
    }

    public static DefaultPieDataset createSamplePieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        // Populate dataset with values from your database
        dataset.setValue("Category 1", 100);
        dataset.setValue("Category 2", 150);
        // Add more data...
        return dataset;
    }



}
