package com.example.springboot3_007_log_system.two_log_system;

import java.util.logging.Logger;

public class JulMain {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JulMain.class.getName());
        logger.info("基于jul");
    }
}
