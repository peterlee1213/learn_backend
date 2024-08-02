# 实现基于数据库的用户认证流程

+ 程序启动时
  + 创建`DBUserDetailsManager`类，实现接口`UserDetailsManager`和`UserDetailsPasswordService`
  + 在应用程序中初始化这个类的对象（成为bean）
+ 校验用户时
  + SpringSecurity自动使用`DBUserDetailsManager`的`loadUserByUsername`方法从`数据库中`获取User对象
  + 在`UsernamePasswordAuthenticationFilter`过滤器中的`attemptAuthentication`方法中将用户输入的用户名密码和从数据库中获取的用户信息进行比较，进行用户认证

# Spring Security默认配置

spring security引入之后的所有默认行为都是在这里定义的，在`WebSecurityConfig`中默认有如下配置：

```java
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 开启授权保护
        http
                .authorizeHttpRequests(authorize -> authorize
                        // anyRequest表示对所有请求开启授权保护
                        .anyRequest()
                        // 已认证的用户授权全部权限
                        .authenticated())
                // 自动使用表单授权
                .formLogin(withDefaults())
                // 使用基本授权方式, 可删除
                .httpBasic(withDefaults());
        return http.build();
    }
```

# 整合swagger

在pom中引入如下依赖：
```xml
<dependency>
  <groupId>com.github.xiaoymin</groupId>
  <artifactId>knife4j-openapi3-jakarta-spring-boot-starter</artifactId>
  <version>4.1.0</version>
</dependency>
```

重启项目之后访问`<localhost_address>/doc.html`

然后左侧控制面板可看到我所有controller，可以点开并进行调试

因为默认开启了CSRF攻击防御，所以无法用调试工具直接发送请求，这里可以暂时关掉CSRF：

```

```