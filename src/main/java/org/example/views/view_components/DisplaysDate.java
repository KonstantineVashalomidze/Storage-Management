package org.example.views.view_components;


import java.time.LocalDate;

public interface DisplaysDate
{
    // this method must be implemented so after the custom date picker selects date it will destroy itself and call this method with
    // selected date
    void displayDateFrom(LocalDate date);
    void displayDateTo(LocalDate date);
}
