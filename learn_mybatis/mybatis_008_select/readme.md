如果返回结果只有一个或0个使用`Car`作为返回类型是没有问题的
但是如果有多个的话就必须使用`List<Car>`, 只有一条返回结果使用`List<Car>`接收是没有问题的

---

如果有合适的POJO对象接收返回结果自然最好
如果没有的话我最好创造一个Map来接收返回的结果

---

可以返回一个存储Map集合的List, `List<Map<String, Object>>`等同于`List<Car>`

---

`List<Map<String, Object>>`返回一个数组,如果我要找某个id对应的对象就得遍历,这种情况下我可以创建一个Map集合`Map<String, Map<String Object>>`, 外层的String key就是主键id, `Map<String Object>`就是对象
在CarMapper.java这个接口中
```
@MapKey("id)
Map<Long, Map<String, Object>> selectAllByMap();
```

---

解决查询结果跟POJO类对应不上的解决方案
1. 使用resultMap进行结果映射,具体参照CarMapper.xml文件
2. 使用as起别名
3. 开启驼峰命名自动映射, 前提是java和sql字段都符合命名规范
   1. java: 首字母小写,后面每个单词首字母大写,遵循驼峰命名方式
   2. sql: 全部小写, 单词之间用下划线连接
   3. 开启方式: 在mybatis主配置文件中添加一个设置项, 具体参照mybatis-config.xml
