# 依赖管理机制

1. 为什么导入`starter-web`所有相关依赖都导入进来了
   1. 开发什么场景导入场景启动器就好了
   2. 场景启动器一般都以`spring-boot-starter.....`开始
   3. 场景启动器点进去有很多依赖以及其他场景启动器,比如A依赖B,B依赖C,只要导入A其他依赖都装好了
2. 为什么不用写版本号
   1. pom文件中点进spring-boot-starter-parent后点进spring-boot-dependencies可发现很多依赖都有版本信息,早已在这里定义好与当前springboot版本最契合的常见依赖版本了
   2. 自定义版本号,利用maven就近原则,可在当前pom文件的properties标签中指定特定依赖的版本号,也可在dependency标签中写死版本号

# 自动配置机制
+ 默认包扫描规则
  + SpringBoot默认只扫描主程序所在的包及其下面的子包, 即`@SpringBootApplication`标注的类所在的包
  + 也可自定义扫描路径
    + `@SpringBootApplication(scanBasePackages = "com.powernode")`
    + 或者在主程序类上方添加注解`@ComponentScan("com.powernode")`
+ 配置默认值
  + 配置文件的所有配置项都是和某个类对象值进行一一绑定的
  + 绑定了配置文件中每一项值的类: 配置属性类
  + 比如ServerProperties这个类存储了server.xxx.....有关的配置
  + 比如MultipartProperties绑定了所有文件上传相关的配置
  + 具体参照官方文档
+ 按需加载自动配置
  + 所有的starter都有一个spring-boot-starter包
  + 所有的spring-boot-starter包都有`spring-boot-autoconfig`,打开这个包看下可发现所有依赖的自动配置类都在这里
  + 虽然全场景的自动配置都在这个包中,但不是全都开启的

# 常用注解
+ 组件注册为bean
  + @Configuration    (放在类上,参照AppConfig)
    + 告诉springboot这是一个配置类,
    + @bean
      + @Configuration类下带有@Bean的方法返回的对象都会被当作bean交给spring容器管理,组件在容器中的id默认是方法名(如果没有提供的话)
      + 创建的组件默认是singleton
      + 可以在@Bean的方法上加@Scope("prototype|singleton")来改变Bean的scope
  + @Import(组件.class)     放在类上
    + 给容器中放入指定类型的组件,组件id默认是全类名
  
# 条件注解 (看config/ConditionalAnnotationTest)
如果注解指定的条件成立则触发指定行为,通常是@ConditionalOnXxxxxxx
常用的条件注解
+ @ConditionalOnClass
  + 如果类路径中存在这个类,则触发指定行为
+ @ConditionalOnMissingClass
  + 如果类路径中**不**存在这个类,则触发指定行为
+ @ConditionalOnBean
  + 如果容器中存在这个Bean, 则.......
+ @ConditionalOnMissingBean
  + 如果容器中**不**存在这个Bean, 则.......

# 属性绑定
+ `@ConfigurationProperties`将配置文件中配置项的值绑定为Bean的属性值,具体看bean/Pig.java
+ `@EnableConfigurationProperties`其值是一个class,其作用是开启此class的属性绑定, 可快速将一个class注册为Bean,常用于使用第三方组件库的时候进行属性绑定
# 自动配置
+ @SpringBootApplication由3个注解组成:@SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan
+ @EnableConfiguration负责将`spring-boot-autoconfig`包中的所有配置类导入进来(所有自动 配置类都有@ConditionalOnClass注解,也就是只有特定类被导入到项目中才会有哪个配置类的Bean)