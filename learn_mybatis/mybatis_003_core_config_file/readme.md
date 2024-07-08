# 环境environments
参考multi-env.xml
1. 每个环境(environment)代表一个数据库, 不同环境下可连接不同的数据库
   1. transactionManager标签的type参数可以是JDBC和MANAGED
      1. JDBC表示使用JDBC的事务管理器
      2. MANAGED表示mybatis不使用事务管理器,此时一般使用其他框架提供的事务管理器,比如spring boot
   2. dataSource表示数据源, 有多种type, 为程序提供Connection对象, 但凡是给程序提供Connection对象的都叫数据源, 数据源是一套JDK规范javax.sql.DataSource, 任何实现了此接口的类都叫数据源 
      1. POOLED 使用mybatis自己的数据库连接池
      2. UNPOOLED   不适用数据库连接技术,每次请求过来都创建新的Connection对象

# properties
参考properties.xml
设置一些通用变量, 即可在同一配置文件的多个地方引用, 改的时候也只改一个地方

有两种定义方法:
1. 在xml文件的properties下的property属性下配置
2. 单独写一个properties文件然后在xml文件中引入进来