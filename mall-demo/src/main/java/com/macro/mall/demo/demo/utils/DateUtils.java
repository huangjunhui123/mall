package com.macro.mall.demo.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

/**
 * 日期工具类
 */
@Slf4j
public class DateUtils {

    /**
     * 日期格式
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYY_MM_DD_POINT = "yyyy.MM.dd";
    public static final String DATE_FORMAT_YYYY_MM_DD_SLASH = "yyyy/MM/dd";
    public static final String FORMAT__YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT__YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT__YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";

    /**
     * 获得格式化日期
     *
     * @param date      日期
     * @param formatStr 日期格式
     */
    public static String getFormatDate(Date date, String formatStr) {
        if (date != null) {
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            return getFormatDate(cd, formatStr);
        }
        return "";
    }

    /**
     * 获得格式化日期
     *
     * @param date      日期
     * @param formatStr 日期格式
     */
    public static String getFormatDate(Calendar date, String formatStr) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr, Locale.CHINA);
        return dateFormat.format(date.getTime());
    }


    /**
     * 获取上个月
     *
     * @return 如: 202008
     */
//    public static String getLastMonth() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date); // 设置为当前时间
//        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
//        date = calendar.getTime();
//        String accDate = format.format(date);
//        return accDate;
//    }

    /**
     * 获取上个月
     *
     * @return
     */
    public static String getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getFormatDate(calendar,"yyyyMM");
    }



    /**
     * 获取前几个月
     *
     * @return 如: 202008
     */
    public static String getLastMonth(int number) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - number); // 设置为上一个月
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;
    }

    /**
     * 获取前几个月
     *
     * @return 如: 202008
     */
    public static Date getLastMonthByDate(int number) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - number); // 设置为上一个月
        return calendar.getTime();
    }

    /**
     * 获取当前日期的几天前或几天后日期
     *
     * @return
     */
    public static Date getCurrentBeforeNum(int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, num);
        return cal.getTime();
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    /**
     * 日期格式化
     * @param fmt
     * @param src
     * @return
     * @throws Exception
     */
    public static Date parse(String fmt, String src) throws Exception {
        if (StringUtils.isBlank(src) || StringUtils.isBlank(fmt)) {
            throw new NullPointerException("Please check param scr or srcFmt is blank");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        sdf.setLenient(false);
        return sdf.parse(src);
    }

    /**
     * 获取下个月第一天
     * @return YYYY-MM-DD 2020-11-01
     */
    public static String nextMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return getFormatDate(calendar,DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     * 获取上个月第一天
     *
     * @return
     */
    public static String getLastMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getFormatDate(calendar,DATE_FORMAT_YYYY_MM_DD);
    }

    public static String formatDateTime(long mss) {
        long minutes = (mss % (60 * 60)) / 60;
        long seconds = mss % 60;

        StringBuilder sb = new StringBuilder();

        if(minutes == 0) {
            sb.append("00:");
        }else if(minutes >= 10) {
            sb.append(minutes).append(":");
        }else {
            sb.append("0").append(minutes).append(":");
        }

        if(seconds == 0) {
            sb.append("00");
        }else if(seconds >= 10) {
            sb.append(seconds);
        }else {
            sb.append("0").append(seconds);
        }


        return sb.toString();
    }





    /**
     * 取这一年的日历
     * @param year
     * @return
     */
    private static Calendar getCalendarFormYear(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }


    /**
     * 返回指定年 月开始日期
     * @param year
     * @param month
     * @return
     */
    public static String getMonthBeginTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));

        return getFormatDate(Date.from(zonedDateTime.toInstant()),DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     * 返回指定年 月结束日期
     * @param year
     * @param month
     * @return
     */
    public static String getMonthEndTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        return getFormatDate(Date.from(zonedDateTime.toInstant()),DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     * 获取某一年的某一周的周日日期
     * @param year
     * @param weekNo
     * @return
     */
    public static String getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);

        String yearStr = cal.get(Calendar.YEAR) < 10 ? "0"+cal.get(Calendar.YEAR) : String.valueOf(cal.get(Calendar.YEAR));
        String monthStr = (cal.get(Calendar.MONTH) + 1) < 10 ? "0"+(cal.get(Calendar.MONTH) + 1) : String.valueOf((cal.get(Calendar.MONTH) + 1));
        String dayStr = cal.get(Calendar.DAY_OF_MONTH) < 10 ? "0"+cal.get(Calendar.DAY_OF_MONTH) : String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        return yearStr + "-" + monthStr + "-" + dayStr;
    }

    /**
     * 获取某一年的某一周的周一日期
     * @param year
     * @param weekNo
     * @return
     */
    public static String getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);

        String yearStr = cal.get(Calendar.YEAR) < 10 ? "0"+cal.get(Calendar.YEAR) : String.valueOf(cal.get(Calendar.YEAR));
        String monthStr = (cal.get(Calendar.MONTH) + 1) < 10 ? "0"+(cal.get(Calendar.MONTH) + 1) : String.valueOf((cal.get(Calendar.MONTH) + 1));
        String dayStr = cal.get(Calendar.DAY_OF_MONTH) < 10 ? "0"+cal.get(Calendar.DAY_OF_MONTH) : String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        return yearStr + "-" + monthStr + "-" + dayStr;
    }

    /**
     * 返回指定年-月 有几天
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDays(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year); // 年
        c.set(Calendar.MONTH, month - 1); // 月
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回指定年-月 指定哪一天
     * @param year
     * @param month
     * @return
     */
    public static String getMonthTime(int year, int month, int day) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(day);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));

        return getFormatDate(Date.from(zonedDateTime.toInstant()),DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     *
     * @param year 年
     * @param timeUnit 时间单位  天/周/半月/月/季度/半年/年
     * @param time 时间
     * @return
     */
    public static Map<String,String> getStartAndEndDate(String year, String timeUnit, String time) {
        log.info("时间单位换算: year: {}, timeUnit: {}, time: {}", year, timeUnit, time);

        Map<String,String> result = null;

        if(StringUtils.isNotBlank(year)) {
            result = new HashMap<>();
            int y = Integer.valueOf(year.replace("年",""));
            result.put("startDate", getMonthBeginTime(y, 1));
            result.put("endDate", getMonthEndTime(y, 12));

            if(StringUtils.isNotBlank(timeUnit) && StringUtils.isNotBlank(time)) {
                result = new HashMap<>();
                switch (timeUnit) {
                    case "天":
                        // 直接拆分时间
                        if(StringUtils.isNotBlank(time)) {
                            time.split("~");
                            result.put("startDate",time.split("~")[0]);
                            result.put("endDate",time.split("~")[1]);
                        }
                        break;
                    case "周":
                        int week = Integer.valueOf(time);

                        result.put("startDate", getStartDayOfWeekNo(y,week));
                        result.put("endDate", getEndDayOfWeekNo(y,week));
                        break;
                    case "半月":
                        if(time.contains("-1")) {// 1-1 1月上半月 1-2 1月下半月
                            // 获取月份，判断天数
                            int month = Integer.valueOf(time.replace("-1",""));
                            if(month > 0) {
                                result.put("startDate", getMonthBeginTime(y, month));
                                result.put("endDate", getMonthTime(y, month, getMonthDays(y,month) / 2));
                            }

                        } else if(time.contains("-2")) {
                            int month = Integer.valueOf(time.replace("-2",""));
                            if(month > 0) {
                                result.put("startDate", getMonthTime(y, month, (getMonthDays(y,month) / 2)+1));
                                result.put("endDate", getMonthEndTime(y, month));
                            }
                        }
                        break;
                    case "月":
                        int month = Integer.valueOf(time);
                        result.put("startDate", getMonthBeginTime(y, month));
                        result.put("endDate", getMonthEndTime(y, month));
                        break;
                    case "季":
                        if("1".equals(time)) {
                            result.put("startDate", getMonthBeginTime(y, 1));
                            result.put("endDate", getMonthEndTime(y, 3));
                        } else if("2".equals(time)) {
                            result.put("startDate", getMonthBeginTime(y, 4));
                            result.put("endDate", getMonthEndTime(y, 6));
                        } else if("3".equals(time)) {
                            result.put("startDate", getMonthBeginTime(y, 7));
                            result.put("endDate", getMonthEndTime(y, 9));
                        } else if("4".equals(time)) {
                            result.put("startDate", getMonthBeginTime(y, 10));
                            result.put("endDate", getMonthEndTime(y, 12));
                        }
                        break;
                    case "半年":
                        if("上半年".equals(time)) {
                            result.put("startDate", getMonthBeginTime(y, 1));
                            result.put("endDate", getMonthEndTime(y, 6));
                        } else if("下半年".equals(time)) {
                            result.put("startDate", getMonthBeginTime(y, 7));
                            result.put("endDate", getMonthEndTime(y, 12));
                        }
                        break;
                    case "年":
                        if("全年".equals(time)) { // 全年
                            result.put("startDate", getMonthBeginTime(y, 1));
                            result.put("endDate", getMonthEndTime(y, 12));
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        log.info("获取到时间段: {}",result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getLastMonth());
    }
}
