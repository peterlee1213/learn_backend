package com.powernode.springboot3_004_configuration_file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powernode.springboot3_004_configuration_file.bean.BindConfigBean;
import com.powernode.springboot3_004_configuration_file.mapListArray.CollectionConfig;
import com.powernode.springboot3_004_configuration_file.specifyPropertiesFile.Group;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/4")
public class TestController {

    // 不需要自定义Bean,直接注入即可
    @Autowired
    private Environment environment;

    /**
     * 测试使用@Value注入application.properties文件中的值
     * 方法：@Value("${key:默认值}")
     * 
     * @param owner
     * @param since
     * @param path
     * @return
     */
    @GetMapping("/testcontroller")
    public String testGetApplicationProperties(@Value("${app.owner}") String owner,
            @Value("${app.since}") Integer since, @Value("${app.path:'自定义值'}") String path) {
        return "owner " + owner + " since " + since + " path " + path;
    }

    /**
     * 获取环境变量
     * 可以是application.properties中的变量，也可以是系统的环境变量，以下例子是获系统环境变量
     */
    @GetMapping("testenv")
    public String getEnvironmentString() {
        // 获取某个key的值
        String name = this.environment.getProperty("USER");

        // 判断某个key的值是否存在
        Boolean isExist = this.environment.containsProperty("app.owner");

        return this.environment.getProperty("USER");
    }

    /**
     * 有多个配置文件的时候可以在application.properties中导入其他配置文件
     */
    @GetMapping("testMultiplePropertiesFiles")
    public String testMultiplePropertiesFiles(@Value("${additional.config}") String config) {
        return config;
    }

    /**
     * 测试多环境下的application-{profile}.properties配置文件
     */
    @GetMapping("testMultiEnv")
    public String testMultiEnv(@Value("${myapp.memo}") String memo) {
        return memo;
    }

    /**
     * c测试将application.properties中特定前缀的配置项通过注解直接赋值给一个Bean
     */
    @Autowired
    @Qualifier("configBean")
    private BindConfigBean bindConfigBean;

    @GetMapping("testConfigToBean")
    public String testConfigToBean() {
        return this.bindConfigBean.toString();
    }

    /**
     * 测试将Map/数组/List类型的配置项保存到配置文件中
     */

    @Autowired
    @Qualifier("collectionConfig")
    private CollectionConfig collectionConfig;

    @GetMapping("testMapArrayList")
    public String testMapArrayList() {
        return this.collectionConfig.toString();
    }

    /**
     * 测试指定除application.properties之外的properties文件中的变量注入一个对象
     */
    @Autowired
    @Qualifier("group")
    private Group group;

    @GetMapping("testSpecifyPropertiesFiles")
    public String testSpecifyPropertiesFiles() {
        return group.toString();
    }

}
