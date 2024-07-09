package _11_regexp;

/**
 * 正则表达式/匹配规则
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1304066080636961
 */
public class MatchRules_1 {
    public static void main(String[] args) {
        basicUseCase();
    }

    // 最基本用法
    public static void basicUseCase() {
        String re = "abc";
        System.out.println("abc".matches(re));
    }
}
