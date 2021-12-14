package com.macro.mall.demo.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间操作工具类
 */
public class FrchainDateUtils extends DateUtils {
    /**
     * 日期格式
     */
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_HH_MM_SS = "HH:mm:ss";
    public static final String DATE_HH_MM = "HH:mm";
    public static final String DATE_FORMAT_YYYY_MM_DD_BIAS = "yyyy/MM/dd";

    /**
     * 日期格式
     */
    public static final String DATE_FORMAT_YYYY_MM_DD_POINT = "yyyy.MM.dd";
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static Date addDays(Date date, int n) {
        if (date == null) {
            return null;
        }
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, n);
        return calendar.getTime();
    }

    public static Date parse(String fmt, String src) throws Exception {
        if (StringUtils.isBlank(src)
                || StringUtils.isBlank(fmt)) {
            throw new NullPointerException("Please check param scr or srcFmt is blank");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        sdf.setLenient(false);
        return sdf.parse(src);
    }

    public static Date parseTimeStr(String src) {
        if (StringUtils.isNotBlank(src)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
            sdf.setLenient(false);
            try {
                return sdf.parse(src);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String format(String fmt, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public static String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_HH_MM_SS);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public static String formatTimeHhMm(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_HH_MM);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public static String formatMonthDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM);
        sdf.setLenient(false);
        return sdf.format(date);
    }

    public static String formatDateIsNull(String fmt, Date date) throws Exception {
        if (StringUtils.isBlank(fmt) || date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        sdf.setLenient(false);
        return sdf.format(date);
    }


    public static String getCron(Date date) throws Exception {
        String cron = format("s m H d M ? yyyy", date);
        return cron;
    }

    /**
     * 本月的第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 本周第几天（周几）
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        if (date == null) {
            return -1;
        }
        Locale.setDefault(Locale.CHINA);
        Calendar calendar = getCalendar(date);
        int dayIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return dayIndex == 0 ? 7 : dayIndex;
    }

    public static Calendar getCalendar(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 获取给定日期月份内的天数
     *
     * @param date
     * @return
     */
    public static int getMonthDays(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取上个月第一天
     *
     * @return
     */
    public static Date getLastMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取当前月第一天
     *
     * @return
     */
    public static Date getCurMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * / 获取前月的最后一天
     *
     * @return
     */
    public static Date getCurMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 获取上个月最后一天
     *
     * @return
     */
    public static Date getLastMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static int getMonthOfYear(String date) {
        if (date.length() != 10) {
            throw new IllegalArgumentException("日期格式不正确");
        }
        return Integer.parseInt(date.substring(5, 7));
    }

    /**
     * 获取两个日期之间的天数：cal2 - cal1
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static int getDaysBetween(Calendar cal1, Calendar cal2) {
        boolean flag = true;
        int days = cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        int year1 = cal1.get(Calendar.YEAR);

        if (year2 < year1) {
            flag = false;
        }
        if (year1 != year2) {
            do {
                days += cal1.getActualMaximum(Calendar.DAY_OF_YEAR);
                if (flag) {
                    cal1.add(Calendar.YEAR, 1);
                } else {
                    cal1.add(Calendar.YEAR, -1);
                }
            } while (cal1.get(Calendar.YEAR) != year2);
        }
        if (flag) {
            return days;
        }
        return -days;
    }

    public static int getDaysAbsBetween(Date date1, Date date2) {
        return Math.abs(getDaysBetween(getCalendar(date1), getCalendar(date2)));
    }

    /**
     * 获取两个日期之间的天数：date2 - date1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDaysBetween(Date date1, Date date2) {
        return getDaysBetween(getCalendar(date1), getCalendar(date2));
    }

    /**
     * 获取两个日期之间相隔月份 cal2 - cal1
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static int getMonthsBetween(Calendar cal1, Calendar cal2) {
        int months = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
        boolean flag = true;

        int year2 = cal2.get(Calendar.YEAR);
        int year1 = cal1.get(Calendar.YEAR);

        if (year2 < year1) {
            flag = false;
        }
        if (year1 != year2) {
            do {
                months += cal1.getActualMaximum(Calendar.MONTH) + 1;
                if (flag) {
                    cal1.add(Calendar.YEAR, 1);
                } else {
                    cal1.add(Calendar.YEAR, -1);
                }
            } while (cal1.get(Calendar.YEAR) != year2);
        }
        if (flag) {
            return months;
        }
        return -months;
    }

    /**
     * 获取两个日期相隔的月份 date2 - date1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthsBetween(Date date1, Date date2) {
        return getMonthsBetween(getCalendar(date1), getCalendar(date2));
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNowDate(String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date sysdDate = null;
        try {
            sysdDate = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sysdDate;
    }

    /**
     * 判断时间是否重叠
     *
     * @param fmt
     * @param startDate1
     * @param endDate1
     * @param startDate2
     * @param endDate2
     * @return true:重叠,false:不重叠
     */
    public static boolean isTimeOverlap(String fmt, String startDate1, String endDate1, String startDate2, String endDate2)
            throws Exception {
        Date date1 = parse(fmt, startDate1);
        Date date2 = parse(fmt, endDate1);
        Date date3 = parse(fmt, startDate2);
        Date date4 = parse(fmt, endDate2);

        // 时间段1的结束时间大于等于时间段2的起始时间
        if (date2.getTime() >= date3.getTime() && date1.getTime() <= date3.getTime()) {
            return true;
        }
        // 时间段1的开始时间大于等于时间段2的结束时间
        else if (date1.getTime() <= date4.getTime() && date2.getTime() >= date4.getTime()) {
            return true;
        }
        // 时间段1的时间段被包含于时间段2
        else if (date1.getTime() >= date3.getTime() && date2.getTime() <= date4.getTime()) {
            return true;
        }
        // 时间段3的时间段被包含于时间段1
        else if (date1.getTime() <= date3.getTime() && date2.getTime() >= date4.getTime()) {
            return true;
        }

        return false;
    }

    /**
     * 判断日期是否在日期范围内
     *
     * @param date       要比较的日期
     * @param startDateS 开始日期
     * @param endDateS   结束日期
     */
    public static Boolean isDateInBetween(String fmt, Date date, String startDateS, String endDateS) {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = parseDate(startDateS, fmt);
            endDate = parseDate(endDateS, fmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDateInBetween(date,startDate, endDate);
    }

    /**
     * 判断日期是否在日期范围内
     *
     * @param date       要比较的日期
     * @param startDateS 开始日期
     * @param endDateS   结束日期
     */
    public static Boolean isDateInBetween(Date date, String startDateS, String endDateS) {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = parseDate(startDateS, DATE_FORMAT_YYYY_MM_DD);
            endDate = parseDate(endDateS, DATE_FORMAT_YYYY_MM_DD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDateInBetween(date, startDate, endDate);
    }

    /**
     * 判断日期是否在日期范围内
     *
     * @param date       要比较的日期
     * @param startDateS 开始日期
     * @param endDateS   结束日期
     */
    public static Boolean isDateInBetweenByHM(Date date, String startDateS, String endDateS) {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = parseDate(startDateS, FORMAT_YYYY_MM_DD_HH_MM);
            endDate = parseDate(endDateS, FORMAT_YYYY_MM_DD_HH_MM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDateInBetween(date, startDate, endDate);
    }

    /**
     * 判断日期是否在日期范围内
     *
     * @param date      要比较的日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     */
    public static Boolean isDateInBetween(Date date, Date startDate, Date endDate) {
        try {
            if (date != null && startDate != null && endDate != null) {
                if (date.after(startDate) && date.before(endDate)) {
                    return true;
                } else if (date.equals(startDate) || date.equals(endDate)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据当前日期获得上周一时间
     *
     * @return
     * @author zhaoxuepu
     */
    public static Date getLastMonday() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 1 - dayOfWeek;
        calendar.add(Calendar.DATE, offset - 7);
        return calendar.getTime();
    }

    /**
     * 获取距某天天时间段的开始时间
     * @return 默认格式 Wed May 31 14:47:18 CST 2017
     */
    public static Date getBeginDayOfDay(int day,Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayStart(date));
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 获取距当天时间段的结束时间
     * @return 默认格式 Wed May 31 14:47:18 CST 2017
     */
    public static Date getEndDayOfDay(int day,Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd(date));
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 获取某个日期的开始时间
     * @param d
     * @return yyyy-MM-dd HH:mm:ss  格式
     */
    public static Date getDayStart(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某个日期的结束时间
     * @param d
     * @return yyyy-MM-dd HH:mm:ss  格式
     */
    public static Date getDayEnd(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 设置近7天，近一个月，近半年，近一年的开始时间
     * 1:近7天，2:近一个月，3:近半年，4:近一年
     */
    public static Date handleTime(int time) {
        Date startTime;
        Date endTime = new Date();
        switch (time) {
            case 1:
                startTime = FrchainDateUtils.getBeginDayOfDay(-7, endTime);
                break;
            case 2:
                startTime = FrchainDateUtils.getBeginDayOfDay(-30, endTime);
                break;
            case 3:
                startTime = FrchainDateUtils.getBeginDayOfDay(-180, endTime);
                break;
            default:
                startTime = FrchainDateUtils.getBeginDayOfDay(-365, endTime);
                break;
        }
     return startTime;
    }


    /**
     * 获取时间具体内容
     * @return
     */
    public static String StringData(Date time) {
        final Calendar c = Calendar.getInstance();
        try {
            c.setTime(time);
            String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
            if ("1".equals(mWay)) {
                mWay = "天";
            } else if ("2".equals(mWay)) {
                mWay = "一";
            } else if ("3".equals(mWay)) {
                mWay = "二";
            } else if ("4".equals(mWay)) {
                mWay = "三";
            } else if ("5".equals(mWay)) {
                mWay = "四";
            } else if ("6".equals(mWay)) {
                mWay = "五";
            } else if ("7".equals(mWay)) {
                mWay = "六";
            }
            return new StringBuilder().append(format("yyyy年MM月dd日", time)).append(" 星期")
                    .append(mWay).append(" ").append(format(DATE_HH_MM_SS, time)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取某天时间段距离N月的开始时间
     */
    public static String getBeginDayOfMonth(Date date, int month) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayStart(date));
        cal.add(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return format(DATE_FORMAT_YYYY_MM, cal.getTime());
    }

    /**
     * 获取近month月的字符串
     * @param date
     * @param month
     * @return
     */
    public static List<String> getMonthBetweenString(Date date, int month) {
        List<String> list = new ArrayList<>();
        int begin = month > 0 ? 0 : month;
        int end = month > 0 ? month : 0;
        do {
            list.add(getBeginDayOfMonth(date, begin));
            begin++;
        }while (begin <= end);
        return list;
    }

    /**
     *
     * @param time
     * @param time2
     * @return
     */
    public static List<String> getDayBetweenString(Date time, Date time2) {
        if (time == null || time2 == null) {
            return null;
        }
        if (time.after(time2)) {
            Date time3 = time;
            time = time2;
            time2 = time3;
        }
        Date start = getDayStart(time);
        List<String> list = new ArrayList<>();
        String formatDate = "";
        do {
            formatDate = FrchainDateUtils.formatDate(start);
            list.add(formatDate);
            start = FrchainDateUtils.getBeginDayOfDay(1, start);
        }while (start.before(time2));
        return list;
    }
}
