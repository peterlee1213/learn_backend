package _2_java_object._1_basis.Scope_10_subfiles;

public class Test {
    protected String name = "10";

    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t.t);
    }
}

class Test1 {
    protected String t = "abc";
}
