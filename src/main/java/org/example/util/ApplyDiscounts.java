package org.example.util;

import org.example.models.Product;
import org.example.models.Transaction;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ApplyDiscounts {
    public static void main(String[] args) throws IOException {
        Scanner transactionsScan = new Scanner(new File("transactions.txt"));
        Scanner productScan = new Scanner(new File("ProductData.txt"));

        List<Transaction> transactions = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        while (transactionsScan.hasNextLine())
        {
            var row = transactionsScan.nextLine();
            // Splitting the data based on the pipe character "|"
            String[] splitData = row.split("\\|");

            // Trimming and storing individual elements after splitting
            String transactionID = splitData[0].trim();
            String date = splitData[1].trim();
            String totalCost = splitData[2].trim();
            String customerID = splitData[3].trim();
            String productID = splitData[4].trim();
            String discountsApplied = splitData[5].trim();
            transactions.add(new Transaction(transactionID, date, totalCost, customerID, productID, discountsApplied));
        }

        while (productScan.hasNextLine())
        {
            var row = productScan.nextLine();

            // Splitting the data based on the pipe character "|"
            String[] splitData = row.split("\\|");

            // Trimming and storing individual elements after splitting
            String productName = splitData[0].trim();
            String category = splitData[1].trim();
            String sellingPrice = splitData[2].trim();
            String imageUrl = splitData[3].trim();
            String stockQuantity = splitData[4].trim();
            String description = splitData[5].trim();
            String costPrice = splitData[6].trim();
            String minimumStockLevel = splitData[7].trim();
            String unitOfMeasure = splitData[8].trim();
            String dateAdded = splitData[9].trim();
            String lastUpdated = splitData[10].trim();
            String productID = splitData[11].trim();

            products.add(new Product(productName, category, sellingPrice, imageUrl, stockQuantity, description, costPrice, minimumStockLevel, unitOfMeasure, dateAdded, lastUpdated, productID));

        }

        for (Transaction t : transactions)
        {
            var totalCost = Double.parseDouble(t.getTotalCost());
            var sellingPrice = Double.parseDouble(findProductById(products, t.getProductID()).getSellingPrice());
            t.setDiscountsApplied(formatToOneDecimalPlace(sellingPrice * Math.ceil(totalCost / sellingPrice) - totalCost));
        }

        /*
        *
        *  String transactionID,
    String date,
    String totalCost,
    String customerID,
    String productID,
    String discountsApplied
        * */


        FileWriter fileWriter = new FileWriter("new-transactions.txt");

        for (Transaction t : transactions)
        {
            var sb = new StringBuilder();
            fileWriter.write(
                    sb
                            .append(t.getTransactionID())
                            .append(" | ")
                            .append(t.getDate())
                            .append(" | ")
                            .append(t.getTotalCost())
                            .append(" | ")
                            .append(t.getCustomerID())
                            .append(" | ")
                            .append(t.getProductID())
                            .append(" | ")
                            .append(t.getDiscountsApplied())
                            + "\n"
            );
        }

        fileWriter.close();






    }

    public static String formatToOneDecimalPlace(double value) {
        // Create a DecimalFormat instance to format the value to one decimal place
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setMaximumFractionDigits(1);

        return decimalFormat.format(value);
    }
    public static Product findProductById(List<Product> products, String id)
    {
        for (Product p : products)
        {
            if (p.getProductID().equals(id))
            {
                return p;
            }
        }
        return null;
    }

}
