package com.niantic.services;

import java.util.HashMap;

public class DateConverter {

    private static HashMap<String, String> convertedMonth = new HashMap<>(){{
        put("JANUARY", "01");
        put("FEBRUARY", "02");
        put("MARCH", "03");
        put("APRIL", "04");
        put("MAY", "05");
        put("JUNE", "06");
        put("JULY", "07");
        put("AUGUST", "08");
        put("SEPTEMBER", "09");
        put("OCTOBER", "10");
        put("NOVEMBER", "11");
        put("DECEMBER", "12");
    }};

    public static String convertMonth(String month)
    {
        return convertedMonth.get(month.toUpperCase().trim());
    }
}
