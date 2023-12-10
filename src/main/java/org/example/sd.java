package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class sd {
    public static void main(String[] args) {

        String d1 = "2021-12-07";
        String d2 = "2021-12-09";

        System.out.println(String.valueOf(generateRandomDate(d1, d2)));

    }

    public static LocalDate generateRandomDate(String lowerBound, String upperBound) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(lowerBound, formatter);
        LocalDate endDate = LocalDate.parse(upperBound, formatter);

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay + 1, endEpochDay);

        return LocalDate.ofEpochDay(randomEpochDay);
    }


}
