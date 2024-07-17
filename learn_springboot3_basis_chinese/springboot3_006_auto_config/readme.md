在`spring-boot-autoconfigure-x.x.x.jar`的`META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`文件包含所有自动配置类列表

---

自动配置原理：
`@SpringBootApplication`这个annotation点进去发现上方有个`@EnableAutoConfiguration`，说明自动配置默认是启用的
再点进去，发现有个`@Import({AutoConfigurationImportSelector.class})`
再点进去这个class,里面有一个`selectImports`方法，这个方法会自动选择加载哪些自动配置类

---

从自动配置类中获取需要哪些配置项(以mybatis举例)：
点进自动配置类，会发现一个`@EnableConfigurationProperties({MybatisProperties.class})`注解，这个注解的意思是从properties文件中将配置绑定到`MybatisProperties.class`,这个自动配置类还有`@Conditional`这类注解以标注这个自动配置类在什么情况下起作用

点进这个`MybatisProperties.class`我们会发现它有个`@ConfigurationProperties(prefix = "mybatis")`，就是说所有mybatis开头的配置都会与这个配置类相绑定
