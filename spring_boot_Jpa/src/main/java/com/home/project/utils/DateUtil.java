package com.home.project.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String getWeek(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.WEEK_OF_YEAR);
        int year = c.get(Calendar.YEAR);

        return year + "." + dayOfWeek;
    }
}
