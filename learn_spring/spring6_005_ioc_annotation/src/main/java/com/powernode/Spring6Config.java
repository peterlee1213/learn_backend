package com.powernode;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 可写一个配置文件代替整个xml文件
 */

@Configuration
@ComponentScan({ "com.powernode" })
public class Spring6Config {

}
