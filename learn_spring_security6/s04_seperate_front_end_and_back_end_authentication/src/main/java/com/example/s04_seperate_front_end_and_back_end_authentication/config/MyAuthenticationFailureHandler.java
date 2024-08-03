package com.example.s04_seperate_front_end_and_back_end_authentication.config;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson2.JSON;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 自定义认证失败后的操作/返回给客户端的数据
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        String localizedMessage = exception.getLocalizedMessage(); // 获取登陆失败的信息

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", -1); // 成功的时候响应码为0
        result.put("message", "login failed");

        // 将结果对象转换成json字符串
        String json = JSON.toJSONString(result);

        // 返回json数据到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);

    }

}
