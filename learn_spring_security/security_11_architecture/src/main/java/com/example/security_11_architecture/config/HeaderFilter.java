package com.example.security_11_architecture.config;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 不要将filter声明为bean,因为这可能导致这个filter被调用两次
public class HeaderFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest thisRequest = (HttpServletRequest) request;
        HttpServletResponse thisResponse = (HttpServletResponse) response;

        // 获取特定header的值
        String header = thisRequest.getHeader("Authentication");
        if(header != null && header.equals("123")){
            // 如果验证通过则继续执行剩余的filter
            chain.doFilter(request, response); 
            return;
        }
        // 验证不通过就在这里中断并报错
        // 这回直接返回一个500给客户端，我可以在SecurityConfig中定义一个ExceptionHandler来处理这个错误
        throw new AccessDeniedException("Access denied");
    }
    
}
