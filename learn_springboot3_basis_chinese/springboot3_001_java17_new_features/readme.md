# Java Record

一个数据记录类，初始化时指定其值，只能读不能写, 可添加实例方法和静态方法

参考TestClass中的testRecord

# Switch语句

1. 使用箭头函数代替冒号可省略break语句
2. 使用yield关键字可直接对变量赋值

详情参考SwitchClass.java

# 文本块

```java

String name = """
    zhangsan
    20
"""；

```

可写多行字符串，但是注意`”“”`不要与任何字符串同行

```java

String name = """
    Name:%s
    Phone:%s
    Age:%d
""".formatted("张三"，“12345678901”，12)；

```

以上代码表示多航字符串可使用格式化方法替换特定内容，这对于后期sql语句中替换特定参数大有作用

# sealed 关键字

使用此关键字修饰的类或接口只能被指定的类或接口继承或实现