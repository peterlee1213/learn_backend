package com.powernode;

public class SwitchClass {

    /**
     * 箭头表达式可无需使用break
     */
    public void testBasicArrowExpression() {
        int week = 7;
        String memo = "";

        switch (week) {
            case 1 -> memo = "星期日， 休息";
            case 2, 3, 4, 5, 6 -> memo = "工作日";
            case 7 -> memo = "星期六， 休息";
            default -> throw new RuntimeException("无效日期");
        }

        System.out.println(memo);
    }

    /**
     * 测试yield返回值
     */

    public void testYield() {
        int week = 7;
        String memo = "";

        memo = switch (week) {
            case 1 -> {
                yield "星期日， 休息";
            }
            case 2, 3, 4, 5, 6 -> {
                yield "工作日";
            }
            case 7 -> {
                yield "星期六， 休息";
            }
            default -> {
                yield null;
            }
        };

        System.out.println(memo);
    }
}
