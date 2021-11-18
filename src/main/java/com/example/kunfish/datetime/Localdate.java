package com.example.kunfish.datetime;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Localdate {

    @Test
    void demo_today() {
        LocalDate today = LocalDate.now(); // Today’s date
        System.out.println("today: " + today);
    }

    @Test
    void demo_specificDay() {
        LocalDate  javaBirthday = LocalDate.of(1996, Month.JANUARY, 23);
        // Uses the Month enumeration
        System.out.println("javaBirthday: " + javaBirthday);
    }

    @Test
    void demo_dayForwardOrBack() {
        int days = 300;
        LocalDate programmersStartDay = LocalDate.of(2016, 8, 15);
        System.out.println("programmersStartDay + " + days +" days: " + programmersStartDay.plusDays(days) );

        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));
    }

    @Test
    void demo_calculateDays(){
        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 4);
        LocalDate christmas = LocalDate.of(2018, Month.DECEMBER, 25);
        System.out.println("Until christmas: " + independenceDay.until(christmas)); // respenting months and days
        System.out.println("Until christmas: " + independenceDay.until(christmas, ChronoUnit.DAYS)); // only respenting days
    }

    @Test
    void demo_dayOfWeek(){
        LocalDate startOfLastMillennium = LocalDate.of(2021, 11, 17);
        System.out.println("startOfLastMillennium: " + startOfLastMillennium + " "+startOfLastMillennium.getDayOfWeek());
        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }

    @Test
    void demo_calendar(){
        LocalDate start = LocalDate.of(2021, 1, 1);
        LocalDate endExclusive = LocalDate.now();
        Stream<LocalDate> firstDaysInMonth = start.datesUntil(endExclusive, Period.ofMonths(1));
        System.out.println("firstDaysInMonth: "
                + firstDaysInMonth.collect(Collectors.toList()));
    }

}
