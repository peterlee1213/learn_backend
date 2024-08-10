package com.example.s01_fundment.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson2.JSON;
import com.example.s01_fundment.entities.vo.LoginUser;
import com.example.s01_fundment.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * OncePerRequestFilter过滤器的特征是，对于每一个servlet请求，只会执行一次
 * 
 * 之前重写了登陆的接口和逻辑，以及authenticate方法
 * 但是还要实现每次请求只要携带jwt并且jwt验证无误就算是登陆成功了，不然springsecurity还是会从请求的cookie中寻找JSESSIONID
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // url是http://localhost/hello?id=12
        String uri = request.getRequestURI();

        // 访问登陆接口直接放行
        if (uri.equals("/user/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 没有token直接报错，程序中止
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasLength(token)) {
            throw new RuntimeException("没有token,禁止访问");
        }

        // 校验令牌
        try {
            Claims jwt = JwtUtil.parseJWT(token);
            String loginUserString = jwt.getSubject();
            // 把字符串转换为loginUser对象
            LoginUser loginUser = JSON.parseObject(loginUserString, LoginUser.class);
            System.out.println(loginUser);
            // 这句话的意思是放行，继续走向下一个过滤器
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
