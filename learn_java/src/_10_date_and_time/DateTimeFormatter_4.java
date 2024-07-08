package _10_date_and_time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期和时间/DateTimeFormatter
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1303985694703650
 */
public class DateTimeFormatter_4 {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(formatter.format(zdt));
    }
}
