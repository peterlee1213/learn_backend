package _10_date_and_time;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期与时间/Date和Calendar
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1303791989162017
 */
public class DateAndCalendar_1 {
    public static void main(String[] args) {
        numberExample();
        getCurrentTimeMillis();
        DateUseCase();
        simpleDateFormatUseCase();
        CalendarUseCase();
        CalendarSetDateUseCase();
        timezoneUseCase();
    }

    // 我们将一个数字存储在内存中，然后用不同的方法将其转换为不同的形式
    public static void numberExample() {
        int n = 123400;
        System.out.println(Integer.toHexString(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(123578956723475.2345));
    }

    // 获取当前时间戳
    public static void getCurrentTimeMillis() {
        System.out.println(System.currentTimeMillis());
    }

    // Date基本用法
    public static void DateUseCase() {
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 年份必须加上1900
        System.out.println(date.getMonth() + 1); // 默认值0-11
        System.out.println(date.getDate());
        System.out.println(date.toString());
        System.out.println(date.toGMTString()); // GMT格林威治标准时间
        System.out.println(date.toLocaleString()); // 转换为本地时间
    }

    // 自定义时间格式输出
    public static void simpleDateFormatUseCase() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

    // Calendar基本用法
    public static void CalendarUseCase() {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
    }

    // 使用Calendar设置时间和日期
    public static void CalendarSetDateUseCase() {
        Calendar c = Calendar.getInstance();
        c.clear(); // 清除所有时间信息
        c.set(Calendar.YEAR, 2050);
        c.set(Calendar.MONTH, 8); // 8表示9月份
        c.set(Calendar.DATE, 2);

        // 设置时间
        c.set(Calendar.HOUR_OF_DAY, 22);
        c.set(Calendar.MINUTE, 22);
        c.set(Calendar.SECOND, 22);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
    }

    // TimeZone对象可转换Calendar对象时区
    public static void timezoneUseCase() {
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00)");
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(tzNY);
        System.out.println(sdf.format(c.getTime()));
    }
}
