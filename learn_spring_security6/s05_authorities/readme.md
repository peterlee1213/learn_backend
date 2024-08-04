# 权限设计方式

1. 用户-权限-资源： 一个用户分配一个或多个权限，每个权限操作一个或多个资源
2. 用户-角色-权限-资源（RBAC, Role-Based Access Control）： 在更复杂的场景中使用此架构： 一个用户有一个或多个角色，一个角色拥有一个或多个权限，一个权限操作一个或多个资源

# 授权方式

1. 基于request的授权
2. 基于方法的授权

## 授予权限时需要注意
如果代码如下：
```
.requestMatchers("/admin/list").hasAuthority("ADMIN_LIST")
.requestMatchers("/admin/**").hasRole("ADMIN")
```
这会导致如果一个用户有ADMIN角色但是没有分配ADMIN_LIST权限，他会被禁止访问/admin/list  
所以权限分配应当从详细到模糊，每条url授权时要指明所有的角色+权限

可以将403回应设置为json格式

# RBAC数据库设计方式
+ 用户表
+ 角色表
+ 权限表
+ 用户-角色表，用户ID和角色ID成为联合主键，用户和角色是多对多的关系，一个用户有多个角色，一个角色可分配给多个用户
+ 角色-权限表，角色ID和权限ID成为联合主键，角色和权限是多对多的关系，一个角色有多个权限，一个权限可分配给多个用户

# 基于方法的授权
1. 首先要在WebSecurityConfig类上添加`@EnableMethodSecurity`，表示开启基于方法的授权
2. 在方法上通过添加`@PreAuthorize("hasRole(...)")`注解表示在方法执行之前检查是否有特定角色或者权限

注意：如果没有`@PreAuthorize`这个注解且没有基于URL的授权的话默认只要登陆成功就能访问

`@PreAuthorize`还可以写得更复杂，比如：
```
@PreAuthorize("hasRole('ADMIN') and authentication.name = 'admin'")
```
表示不光用户得拥有ADMIN这个role,登陆用户还得是admin

roles和authorities不能同时使用，后面的会覆盖掉前面的

除了`hasRole`之外还有`hasAuthority`这个关键字

# 基于方法的授权和基于URL的授权相结合

所有基于URL的授权都要写在http.authorizeHttpRequests中，如果规则很多很复杂且每一条都要写在URL授权配置中的话这个列表会很长
比如URL名称可能很复杂，对URL的访问控制粒度需要控制的很细，同时还要兼顾URL授权的顺序，这是一件很麻烦的事儿，此时可这样：

1. URL授权中只进行粗粒度的控制，比如
```
.requestMatchers("/admin/**").hasRole("ADMIN")
.requestMatchers("/user/**").hasRole("USER")
```
2. 在方法授权上进行细粒度的控制
比如敏感的操作上在额外验证是否还有额外的角色或权限，比如ADMIN_EXTRA之类的角色或权限

