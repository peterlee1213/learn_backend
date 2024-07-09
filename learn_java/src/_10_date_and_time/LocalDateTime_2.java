package _10_date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期和时间/LocalDateTime
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1303871087444002
 */
public class LocalDateTime_2 {
    public static void main(String[] args) {
        localDateTimeCommonUseCase();
        createLocalDateTime();
        createLocalDateTimeFromString();
        customDateOutputFormat();
        calculateDateTime();
        setDateTime();
    }

    // LocalDateTime常用方法
    public static void localDateTimeCommonUseCase() {
        LocalDateTime dt = LocalDateTime.now(); // 获取当前日期(年月日)和时间(时分秒毫秒)
        LocalDate d = dt.toLocalDate();
        LocalTime t = dt.toLocalTime();
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);
    }

    // 通过指定日期和时间创建LocalDateTime
    public static void createLocalDateTime() {
        LocalDate d = LocalDate.of(2022, 2, 2);
        LocalTime t = LocalTime.of(12, 12, 12);
        LocalDateTime dt = LocalDateTime.of(2222, 2, 2, 2, 2, 2);
        System.out.println(dt);
    }

    // 通过字符串(满足ISO 8601)创建日期时间
    public static void createLocalDateTimeFromString() {
        LocalDateTime dt = LocalDateTime.parse("2019-11-19T15:16:17");
        System.out.println(dt);
    }

    // 自定义输出格式
    public static void customDateOutputFormat() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
    }

    // 时间计算
    public static void calculateDateTime() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.plusDays(12).minusHours(5));
    }

    // 设置时间
    public static void setDateTime() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.withYear(2222));
        System.out.println(dt.withDayOfMonth(22));
    }

}
