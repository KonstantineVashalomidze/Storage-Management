package org.example.views.view_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;

public class CustomDatePickerPanel extends JPanel {

    private final BetterLabel selectedDateLabel;
    private final JPanel calendarPanel;
    private LocalDate selectedDate;

    public CustomDatePickerPanel() {
        setLayout(new BorderLayout());

        selectedDate = LocalDate.now();

        selectedDateLabel = new BetterLabel("");
        displayCurrentYear();
        add(selectedDateLabel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel(new FlowLayout());

        BetterButton prevYearButton = new BetterButton("<<");
        prevYearButton.addActionListener(e -> {
            updateCalendar(-1, 0);
            displayCurrentYear();
        });

        BetterButton prevMonthButton = new BetterButton("<");
        prevMonthButton.addActionListener(e -> {
            updateCalendar(0, -1);
            displayCurrentYear();
        });

        BetterButton nextMonthButton = new BetterButton(">");
        nextMonthButton.addActionListener(e -> {
            updateCalendar(0, 1);
            displayCurrentYear();
        });

        BetterButton nextYearButton = new BetterButton(">>");
        nextYearButton.addActionListener(e -> {
            updateCalendar(1, 0);
            displayCurrentYear();
        });

        controlPanel.add(prevYearButton);
        controlPanel.add(prevMonthButton);
        controlPanel.add(nextMonthButton);
        controlPanel.add(nextYearButton);

        add(controlPanel, BorderLayout.SOUTH);

        calendarPanel = new JPanel(new GridLayout(0, 7));
        updateCalendar(0, 0);
        add(calendarPanel, BorderLayout.CENTER);
    }

    private void updateCalendar(int yearChange, int monthChange) {
        selectedDate = selectedDate.plusYears(yearChange).plusMonths(monthChange);

        calendarPanel.removeAll();

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            BetterLabel dayLabel = new BetterLabel(day);
            calendarPanel.add(dayLabel);
        }

        YearMonth yearMonthObject = YearMonth.from(selectedDate);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i < dayOfWeek; i++) {
            JLabel emptyLabel = new JLabel("");
            calendarPanel.add(emptyLabel);
        }

        for (int i = 1; i <= daysInMonth; i++) {
            BetterButton dayButton = new BetterButton(String.valueOf(i));
            int day = i;
            dayButton.addActionListener(e -> {
                selectedDate = LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), day);
                displayCurrentYear();
            });
            calendarPanel.add(dayButton);
        }

        revalidate();
        repaint();
    }

    private void displayCurrentYear()
    {
        selectedDateLabel.setText(("" + selectedDate).substring(0, 4));
    }



}
