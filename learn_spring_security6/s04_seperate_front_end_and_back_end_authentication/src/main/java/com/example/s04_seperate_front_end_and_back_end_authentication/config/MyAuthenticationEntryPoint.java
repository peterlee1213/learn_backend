package com.example.s04_seperate_front_end_and_back_end_authentication.config;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.alibaba.fastjson2.JSON;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 默认用户访问未授权页面时会自动跳转到登陆页面
 * 这个行为也可被替换为只返回一个json串
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        Object localizedMessage = authException.getLocalizedMessage();

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", -1);
        result.put("message", localizedMessage);

        // 将结果对象转换成json字符串
        String json = JSON.toJSONString(result);

        // 返回json数据到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }

}
