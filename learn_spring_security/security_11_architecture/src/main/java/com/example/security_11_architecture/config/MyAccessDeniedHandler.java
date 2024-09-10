package com.example.security_11_architecture.config;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.alibaba.fastjson2.JSON;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", -1);
        result.put("message", "no priviledge");

        // 将结果对象转换成json字符串
        String json = JSON.toJSONString(result);

        // 返回json数据到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }

}
