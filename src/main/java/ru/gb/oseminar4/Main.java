package ru.gb.oseminar4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        Date now = Calendar.getInstance().getTime();

        System.out.println(dateFormat.format(now));
    }
}