package _10_date_and_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 日期和时间/Instant
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1303905346519074
 */
public class Instant_5 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        ZonedDateTime zdt = now.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
    }
}
