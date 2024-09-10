# 快速上手(连接数据库并进行最基本的增删改查)

1. 在`application.properties`将数据库配置好
2. 定义一个`private SessionFactory sf`, 然后直接用`@Autowired`注入进来就可以拿来`openSession`了

# session的find和load的区别

+ `find`会立即进行sql查询
+ `load`会用到的时候才进行sql查询

HibernateTest.java/testFind

