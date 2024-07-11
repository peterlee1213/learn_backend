mybatis缓存机制

查询后的结果放到缓存中,下次相同的查询不再去数据库而是直接从缓存中拿, 如果执行了增删改等任何操作, 缓存中的这条数据就删除了, 完全不必担心这个问题

缓存只针对select语句

---

mybatis缓存包括
+ 一级缓存: 将查询到的数据存储到SqlSession中(仅当前会话有效,一旦sqlsession被close就没了)
  + 默认开启
  + 同一个sqlSession在第一次DQL和第二次DQL之间做了以下事会使一级缓存清空
    + 执行了sqlSession.clearCache()
    + 执行了insert/delete/update语句, 不管操作的是那张表都会清空一级缓存
+ 二级缓存: 查询到的数据放到SqlSessionFactory中(只要程序还在运行就有效)
  + 默认开启
  + 需要在XxxxMapper.xml文件中加一个`<cache />`标签表示在此xml文件中开启二级缓存
  + 需要pojo对象实现java.io.Serializable接口
  + SqlSession对象关闭或提交之后,一级缓存中的数据才会被写入二级缓存中,此时二级缓存才能用
+ 第三方缓存, EhCache