package com.example.s04_seperate_front_end_and_back_end_authentication.config;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import com.alibaba.fastjson2.JSON;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 会话并发处理:后登陆的帐号会让先登陆的帐号失效
 */
public class MySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", -1);
        result.put("message", "you has login from another client");

        // 将结果对象转换成json字符串
        String json = JSON.toJSONString(result);

        HttpServletResponse response2 = event.getResponse();

        // 返回json数据到前端
        response2.setContentType("application/json;charset=UTF-8");
        response2.getWriter().println(json);
    }

}
