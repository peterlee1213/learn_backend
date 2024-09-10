package com.example.s04_seperate_front_end_and_back_end_authentication.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson2.JSON;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 自定义的登陆成功后的操作/给客户端返回的结果
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal(); // 获取用户身份信息
        // Object credentials = authentication.getCredentials(); // 获取用户凭证信息
        // Collection<? extends GrantedAuthority> authorities =
        // authentication.getAuthorities(); // 获取用户权限信息

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0); // 成功的时候响应码为0
        result.put("message", "login success");
        result.put("data", principal);

        // 将结果对象转换成json字符串
        String json = JSON.toJSONString(result);

        // 返回json数据到前端,而非默认返回一个302重定向到首页
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);

    }

}
