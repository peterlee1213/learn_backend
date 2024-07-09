package _2_java_object._2_core_class;

/**
 * [面向对象编程/java核心类/记录类]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1331429187256353
 */
public class RecordClass_4 {
    public static void main(String[] args) {
        // 记录类可拿来记录某些中间数据
        PointRecordClassWithParamCheck p = new PointRecordClassWithParamCheck(12, 23);
        p.x();
        p.y();
    }
}

final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}

// 这行代码等同于以上的Point class
record PointRecordClass(int x, int y) {
}

// 带参数检查的record类
record PointRecordClassWithParamCheck(int x, int y) {
    public PointRecordClassWithParamCheck {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("x or y less than 0");

        // 编译器会继续在后面加上x和y的赋值语句
    }
}
