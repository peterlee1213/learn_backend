package _3_exception;

/**
 * [异常处理/自定义异常]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264737765214592#0
 */
public class CustomException_4 {
    public static void main(String[] args) {

    }
}

// 异常定义的范式如下
class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}

class UserNotFoundException extends BaseException {
}

class LoginFailedException extends BaseException {

}
