package com.ylkj.ems.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * @param date
     * @return "yyyy-MM-dd" 格式的String
     */
    public static final String date2String(Date date) {
        if (date == null)
        {return "";}
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
