在java程序中获取application.properties的值
具体参照TestController.java的testGetApplicationProperties方法

---

Environment这个类可以可获取环境变量, 不光是application.properties, 还包括系统环境变量
具体参照TestController.java中的getEnvironmentString方法

---

集成多个中间件的时候可以配置多个配置文件，然后将这些配置文件集成到application中
参照TestController.java中的testMultiplePropertiesFiles方法

---

多环境配置是指不同环境下采用不同的配置文件
在Spring中`Profiles`表示环境

不同环境的配置命名方式： application-{profile}.properties(yaml)
profile推荐为`dev` `test` `prod` `feature`, 其中feature表示特性

默认的application.properties文件在任何环境下都会被加载，只是如果环境profile配置中的选项会覆盖application.properties的配置

具体查看TestController.java中的testMultiEnv方法


---

我们可以创建一个Bean一键绑定特定前缀的配置项
具体参照TestController.java中的testConfigToBean方法

---

在Bean类上加上`@ConfigurationProperties`注解，以及在主程序类上加`@ConfigurationPropertiesScan(basePackages = {“com.powernode........”})`可实现自动将application.properties中的配置注入到Bean类的属性上

---

如果是第三方class我无法修改源代码，我可以通过创建一个方法，在方法上标注`@Bean`以及`@ConfigurationProperties(prefix = "mywebapp")`来实现

---

如何将配置项绑定到 数组/List/Map，参照TestController.java中的testMapArrayList

---

指定原配置文件（非application.properties）,从指定配置文件里面拿出数据放到类中
参照TestController.java中的testSpecifyPropertiesFiles


