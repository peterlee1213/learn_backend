package com.powernode.annotation;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void login() {
        System.out.println("正在身份认证");
    }

    public void logout() {
        System.out.println("正在退出系统");
    }

    public void exceptionTest() throws Exception {
        throw new Exception("this is Exception");
    }
}
