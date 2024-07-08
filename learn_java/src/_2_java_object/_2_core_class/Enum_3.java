package _2_java_object._2_core_class;

/**
 * [面向对象编程/Java核心类/枚举类]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260473188087424#0
 */
public class Enum_3 {
    public static void main(String[] args) {
        Weekday x = Weekday.FRI;
        Weekday y = Weekday.SUN;
        Weekday[] tabs = new Weekday[] { Weekday.SUN, Weekday.MON };

        // enum是引用类型，但是可以使用==进行比较
        System.out.println(x != y); // true
        System.out.println(x == y); // false

        switch (x) {
            // 枚举类在Switch语句中可不用写类名
            case MON:
                // some code.......
                break;

            default:
                break;
        }

    }
}

enum Weekday {
    // 只需要依次列出枚举的常量名即可
    SUN, MON, TUE, WED, THU, FRI, SAT;
}