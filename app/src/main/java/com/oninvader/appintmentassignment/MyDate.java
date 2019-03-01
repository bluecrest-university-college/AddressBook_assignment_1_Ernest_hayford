package com.oninvader.appintmentassignment;

public class MyDate {
    int year;
    int month;
    int day;

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(){}

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDate(){
        return (new StringBuilder()
                .append(day).append("/")
                .append(month + 1).append("/")
                .append(year)).toString();
    }

}
