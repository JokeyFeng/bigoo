package com.jokey.bigoo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhengjingfeng
 * created 2019/6/17 16:09
 * comment
 */
public abstract class DateUtil {

    /**
     * 格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String getDateFormat(Date date, String dateFormatType) {
        return new SimpleDateFormat(dateFormatType).format(date);
    }
}
