# Validation使用笔记

1. 在接收对象前面加上`@Validated`注解，参考UserController.java
2. 在实体类的对应字段上面加上限制条件
3. 配置global exception把message传递回客户端
4. 重启项目(校验不生效的话)

> 可通过搜索`jakarta.validation.constraints`（jarkata自带的校验）或者`org.hibernate.validator.constraints`（hibernate的校验）查找所有可用的约束
> 方式为`Ctrl+p`，然后输入`#+空格`开始搜索





