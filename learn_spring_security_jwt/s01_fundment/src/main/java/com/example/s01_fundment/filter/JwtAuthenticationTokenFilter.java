package com.example.s01_fundment.filter;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * OncePerRequestFilter过滤器的特征是，对于每一个servlet请求，只会执行一次
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

}
