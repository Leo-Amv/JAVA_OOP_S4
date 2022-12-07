package ru.gb.oseminar4;

import ru.gb.oseminar4.data.Task;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        Date now = Calendar.getInstance().getTime();

        System.out.println(dateFormat.format(now));
        System.out.println(now.getClass().getSimpleName());
    }
}