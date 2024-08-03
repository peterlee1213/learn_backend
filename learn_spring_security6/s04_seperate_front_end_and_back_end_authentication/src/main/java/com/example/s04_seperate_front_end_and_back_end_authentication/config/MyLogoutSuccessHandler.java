package com.example.s04_seperate_front_end_and_back_end_authentication.config;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.alibaba.fastjson2.JSON;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0); // 成功的时候响应码为0
        result.put("message", "logout success");

        // 将结果对象转换成json字符串
        String json = JSON.toJSONString(result);

        // 返回json数据到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }

}
