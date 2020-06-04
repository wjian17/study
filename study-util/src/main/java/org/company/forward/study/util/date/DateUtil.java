//package org.company.forward.study.util.date;
//
//import org.apache.commons.lang3.time.DateFormatUtils;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
///**
// * @author wangjian
// * @date 2020/5/29 0029 15:21
// * LocalDate、LocalTime、LocalDateTime。
// */
//public class DateUtil {
//
//    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//    private static ThreadLocal threadLocal = new ThreadLocal();
//
//
//    public static DateFormat getDateFormat(String dateFormatStr) {
//        if (dateFormat == null) {
//            dateFormat = new SimpleDateFormat(dateFormatStr);
//            threadLocal.set(dateFormat);
//        }
//        return dateFormat;
//    }
//
//    /**
//     * 工具类转化
//     * @param date
//     * @param dateFormat
//     * @return
//     * @throws ParseException
//     */
//    public static String formatDateToString(Date date,String dateFormat) throws ParseException {
//        return DateFormatUtils.format(date,dateFormat);
//    }
//
//    public static Date parseStringToDate(String strDate,String dateFormat) throws ParseException {
//        return getDateFormat(dateFormat).parse(strDate);
//    }
//}