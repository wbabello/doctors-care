package com.project.doctor.appointment.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateFormatUtils {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

    public static String formatDate(Long milliseconds) {
        return dateFormat.format(milliseconds);
    }
}
