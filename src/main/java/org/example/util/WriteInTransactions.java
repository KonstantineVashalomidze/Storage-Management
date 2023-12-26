package org.example.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WriteInTransactions
{


    public static void main(String[] args) throws IOException {


        try {


            FileWriter fileWriter = new FileWriter("purchases.txt");

            Random random = new Random();


            for (int i = 1; i < 2345; i++)
            {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder
                        .append("purchase")
                        .append(i)
                        .append(" | ")
                        .append(generateRandomDate("2019-01-01", "2023-12-12"))
                        .append(" | ")
                        .append(random.nextInt(5, 200))
                        .append(" | ")
                        .append("customer")
                        .append(random.nextInt(1, 500))
                        .append(" | ")
                        .append("product")
                        .append(random.nextInt(1, 500))
                        .append(" | 0");
                fileWriter.write(stringBuilder + "\n");
            }

            fileWriter.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }





    }



    public static String generateRandomDate(String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);

        return LocalDate.ofEpochDay(randomEpochDay).format(DateTimeFormatter.ISO_DATE);
    }


}
