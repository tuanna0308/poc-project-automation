package com.epam.poc.utilities;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeUtil {

    public static String getCurrentTimeByPattern(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(ZonedDateTime.now());
    }
}
