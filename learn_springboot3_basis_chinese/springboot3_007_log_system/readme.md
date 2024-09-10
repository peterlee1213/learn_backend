# 概念

日志系统：
+ log4j2 java官方开发
+ logback 第三方开源开发，用的最广泛

门面框架：一个系统中继承了多个日志系统时将它们的语法和配置统一起来
+ jcl java官方开发
+ slf4j 第三方开源开发，用的最广泛

实际开发中不能直接使用log4j2和logback等日志实现框架提供的API,必须使用日志门面框架提供的API

用slf4j的时候，只要在pom文件中引入log4j和响应桥接器的依赖，slf4j会自动使用

# 日志级别设置

TRACE, DEBUG, INFO, WARN, ERROR, OFF

```yml
logging:
    level:
        root: "warn"
        org.springframework.web: "debug"
        org.hibernate: "error"
        com.example.spring3_007_log_system.two_log_system: "info"
```

如果我日志级别设置为INFO,则只有INFO以及比INFO更严重的日志信息会被输出，也可以针对不同的包设置不同的日志级别，
root表示所有包
如上述代码所示

# 在项目中启用slf4j
总共有两种方式：
## 用代码声明日志记录器
```java
@SpringBootApplication
public class Springboot3007LogSystemApplication {
	// 1. 声明日志记录器
	Logger logger = LoggerFactory.getLogger(Springboot3007LogSystemApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Springboot3007LogSystemApplication.class, args);
	}

}
```

## 用`@SLF4j`这个Lombok注解
不建议使用

# 日志格式

```log
2024-07-30T02:26:39.049Z  WARN 77359 --- [springboot3_007_log_system] [  restartedMain] c.e.s.Springboot3007LogSystemApplication : warn
2024-07-30T02:26:39.049Z ERROR 77359 --- [springboot3_007_log_system] [  restartedMain] c.e.s.Springboot3007LogSystemApplication : error
```
+ 2024-07-30T02:26:39.049Z 日志时间和日期，最后049表示毫秒，Z表示格林威治时区
+ WARN 日志级别
+ 77359 进程ID
+ [springboot3_007_log_system] 项目名称
+ [  restartedMain] 当前线程名称
+ c.e.s.Springboot3007LogSystemApplication 记录日志的类
+ : warn 冒号后是日志内容

# 修改日志格式

在`application.properties`中修改配置项`logging.pattern.console`，具体参照官网
如果配置项中有特殊字符的话用单引号包起来, 默认值如下：
```
%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd'T'HH:mm:ss.SSSXXX}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}
```

+ `%clr( 当前输出内容的颜色 ){faint}` faint可替换为其他颜色
+ `${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd'T'HH:mm:ss.SSSXXX}`  ${value1:value2}表示springboot占位符 + null条件表达式，表示如果value1为null就会使用value2的值，这个`LOG_DATEFORMAT_PATTERN`可以是系统环境变量，也对应着一个`logging.pattern.dateformat`的application.properties配置项,日志配置中一部分环境变量都有对应一个application.properties配置项，`${}`都表示到系统环境变量中取的
+ `%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd'T'HH:mm:ss.SSSXXX}}` %d是logback的格式设置，去logback官网查看
+ `%clr(${LOG_LEVEL_PATTERN:-%5p})` 这个`%5p`表示日志级别且显示长度为5

# 日志以文件的方式进行记录

`logging.file.name`指定日志文件的名称+路径
```
logging.file.name=/var/log/mylog.log
```
# 日志迭代

## 迭代日志文件
```
logging.logback.rollingpolicy.file-name-pattern='${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz'
logging.logback.rollingpolicy.max-file-size=5KB
logging.logback.rollingpolicy.max-history=6
```
+ logging.logback.rollingpolicy.file-name-pattern 指定迭代日志文件名称
+ logging.logback.rollingpolicy.max-file-size 指定单个日志文件大小
+ logging.logback.rollingpolicy.max-history 指定日志文件保留最大天数
---

+ `LOG_FILE`是文件名称，是环境变量，也可从`logging.file.name`中取
+ `%d{yyyy-MM-dd}`是年月日
+ `%i`是索引，如果同一天产生了3个日志，那么`%i`会自动变成1,2,3
  
