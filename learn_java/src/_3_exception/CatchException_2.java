package _3_exception;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * [异常处理/捕获异常]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264738442933472#0
 */
public class CatchException_2 {
    public static void main(String[] args) {

    }

    // 多catch语句顺序很重要，在上一个catch语句捕捉到错误就不会继续执行下面的catch语句了
    public static void multipleCatchSentences() {
        try {
            // some code
        } catch (IOException e) {

            // UnsupportedEncodingException是IOException的子集，所以此错误永远不会捕捉到
        } catch (UnsupportedEncodingException e) {

        }
    }

    // 不管try还是catch中的语句被执行，finally中的语句总是在最后被执行
    public static void finalSentence() {
        try {

        } catch (Exception e) {

        } finally {

        }
    }

    // 一个catch语句可同时处理多种异常
    public static void multipleExceptionsAtOneTake() {
        try {
            // some code
        } catch (IOException | NumberFormatException e) {
            // 此处同时处理以上两种异常
        } catch (Exception e) {

        } finally {

        }
    }
}
