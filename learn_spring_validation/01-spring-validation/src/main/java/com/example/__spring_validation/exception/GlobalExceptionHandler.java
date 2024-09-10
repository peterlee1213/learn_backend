package com.example.__spring_validation.exception;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

// 全局异常处理切面了
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // 这个注解表示函数返回值应当出现在web响应体中
    @ResponseBody
    public String MethodArgumentNotValidExceptionHandler(HttpServletResponse httpServletResponse,
            MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String defaultMessage = fieldErrors.get(0).getDefaultMessage();
        return defaultMessage;
    }

}
