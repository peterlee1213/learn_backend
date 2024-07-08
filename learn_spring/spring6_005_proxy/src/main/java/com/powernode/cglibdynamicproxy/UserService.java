package com.powernode.cglibdynamicproxy;

/**
 * 目标类
 */
public class UserService {
    public boolean login(String username, String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            return true;
        }
        return false;
    }

    public void logout() {
        System.out.println("logout.....");
    }
}
