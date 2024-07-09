package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/多态]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260455778791232#0
 */
public class Polymorphism_5 {
    public static void main(String[] args) {
        Polymorphism_5.overrideUseCase();
        Polymorphism_5.polymorphismUseCase();
        Polymorphism_5.overrideObjectMethods();
        Polymorphism_5.superUseCase();
    }

    // overload是指除了参数之外的其他一切都相同
    // override是指覆盖掉父类的函数，函数签名/函数名/参数必须与父类完全一致
    // @Override可让编译器帮助检查
    public static void overrideUseCase() {
        OverrideChild o = new OverrideChild();
        o.run();
    }

    // 多态指的是针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
    public static void polymorphismUseCase() {
        PolimorphismExample p = new PolimorphismExample(new Income(5000), new Salary(5200));
        p.totalTax();
    }

    // 复写Object的方法
    public static void overrideObjectMethods() {
        OverrideObjectMethods o = new OverrideObjectMethods("Peter");
        System.out.println(o.toString());
    }

    // 可通过super关键字调用父类的字段和方法
    public static void superUseCase() {
        SuperChild s = new SuperChild();
        s.run();
    }
}

class OverrideParent {
    public void run() {
        System.out.println("parent run");
    }
}

class OverrideChild extends OverrideParent {
    @Override
    public void run() {
        System.out.println("student run");
    }
}

class PolimorphismExample {
    Income[] incomes;

    public PolimorphismExample(Income... incomes) {
        this.incomes = incomes;
    }

    public void totalTax() {
        double total = 0.0;
        for (Income income : this.incomes) {
            total += income.getTax();
        }
        System.out.println(total);
    }
}

sealed class Income permits Salary {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1;
    }
}

final class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000)
            return 0;
        return (income - 5000) * 0.2;
    }
}

class OverrideObjectMethods {
    String name;

    public OverrideObjectMethods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person:name=" + name;
    }
}

class SuperParent {
    public void run() {
        System.out.println("parent run");
    }
}

class SuperChild extends SuperParent {
    @Override
    public void run() {
        super.run();
        System.out.println("child run");
    }
}