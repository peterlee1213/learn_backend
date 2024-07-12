## Sql语句的parameterType属性
+ parameterType参数的作用是告诉mybatis我的参数类型是什么,还可以在#{}里面写
+ 大部分情况下可以不写,mybatis可自动推断
+ 详情看StudentMapper.xml中的selectByName

## 多参数时使用@Param注解
传多个参数时mybatis默认生成arg0/arg1/arg2....等等这种参数, 看起来不直观, 可以使用注解来解决这个麻烦



## 各种传参类型参考测试文件




