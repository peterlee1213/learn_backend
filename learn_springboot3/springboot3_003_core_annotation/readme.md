# @SpringBootApplication

点进去可发现它是很多注解的集合，核心有这三个

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
   excludeFilters = {@Filter(
   type = FilterType.CUSTOM,
   classes = {TypeExcludeFilter.class}
), @Filter(
   type = FilterType.CUSTOM,
   classes = {AutoConfigurationExcludeFilter.class}
)}
)
```

+ @SpringBootConfiguration
  + 包含`@Configuration`的功能，加在类上表示此类是配置类，结合@Bean能够将对象注入到IOC容器, 示例代码去HelloController。java的hello()
+ @EnableAutoConfiguration
  + 开启自动配置，将spring和第三方库中的对象创建好，注入到spring容器
+ @ComponentScan
  + 指定从什么地方扫描`@Controller` `@Service` `@Repository` `@Component`类
  + springboot约定：启动类所在目录作为扫描包的根目录

