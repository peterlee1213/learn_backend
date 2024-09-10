package com.example.springboot3_007_log_system.two_log_system;

import org.apache.log4j.Logger;

public class Log4jMain {
    public static void main(String[] args) {
        // 除此之外还要在application.properties做一些配置，这里就不做了，这一节用的主要是logback
        Logger logger = Logger.getLogger(Log4jMain.class);
        logger.info("log4j");
    }
}
