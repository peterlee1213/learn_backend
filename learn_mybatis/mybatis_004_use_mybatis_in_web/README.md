要点:
1. 事务的控制不应该放在Dao里面,应该放在事务里面
2. ThreadLocal对象是一个Map,key是当前线程,value是我存储的对象,适合一个会话共享一个对象的场景,只不过因为key是当前线程,所以在get和set和remove方法中key均可省略
   1. ThreadLocal中不用的对象和属性要及时移除,否则这个Map会越来越大,直至内存溢出
3. 三大对象作用域
   1. SqlSessionFactoryBuilder, 创建完SqlSessionFactory就没用了,所以最好是局部变量
   2. SqlSessionFactory, 每个SqlSessionFactory对应一个数据库, 只要程序执行期间需要一直连接数据库, 就应当只初始化一次并始终存在, 最好设置为全局静态变量
   3. SqlSession, 每个会话或者每个http request一个, 应该是线程安全的, 所以应当存储在线程安全的ThreadLocal中
4. 我们看到DAO的实现类只有格式固定的几行代码,我们可以通过mybatis的代理技术动态生成这些类,这样我们就用不着写它们了
   1. 要想使用这种机制, xml配置文件的namespace必须是对应DAO接口的全限定类名, 而sql语句的id必须得是dao接口的方法名