package _7_generics;

import java.util.Arrays;

/**
 * 泛型/泛型和反射
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265105940850016
 */
public class GenericsAndReflection_7 {
    public static void main(String[] args) {
        Pair<String>[] ps = null;
        // 报错,不能直接new泛型数组
        Pair<String>[] ps1 = new Pair<String>[2];

        // 使用泛型数组必须通过强制转型来实现
        @SuppressWarnings("unchecked")
        Pair<String>[] ps2 = (Pair<String>[]) new Pair[2];

        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        // ClassCastException:
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));

    }

    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
}
