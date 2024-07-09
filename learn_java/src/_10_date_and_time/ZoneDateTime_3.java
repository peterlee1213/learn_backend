package _10_date_and_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 日期和时间/ZonedDateTime
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1303904694304801
 */
public class ZoneDateTime_3 {
    public static void main(String[] args) {
        createZonedDateTime();
        switchTimeZone();
    }

    // 创建ZonedDateTime
    public static void createZonedDateTime() {
        ZonedDateTime zdt = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zdtny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 美国纽约时区

        // 给LocalDateTime添加ZoneId以成为ZonedDateTime
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault()); // 给LocalDateTime添加默认时区

        System.out.println(zdt);
        System.out.println(zdtny);
        System.out.println(zbj);
    }

    // 转换时区
    public static void switchTimeZone() {
        ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }
}
