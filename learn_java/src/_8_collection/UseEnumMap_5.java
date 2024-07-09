package _8_collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 集合/使用EnumMap
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1300277678309410
 */
public class UseEnumMap_5 {
    public static void main(String[] args) {
        // 可以使用Map为一个枚举类的每个枚举属性指定一个值
        Map<WeekDay, String> m = new HashMap<>();
        m.put(WeekDay.MON, "monday");
        m.put(WeekDay.TUE, "tuesday");
        m.put(WeekDay.WED, "wednesday");
        m.put(WeekDay.THU, "thursday");
        m.put(WeekDay.FRI, "friday");
        m.put(WeekDay.SAT, "saturday");
        m.put(WeekDay.SUN, "sunday");
        System.out.println(m.get(WeekDay.TUE));
    }
}

enum WeekDay {
    MON, TUE, WED, THU, FRI, SAT, SUN
}