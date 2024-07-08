1. #{}和${}的区别
   1. #{}
      1. select id,car_num as carNum,brand,guide_price as guidePrice,produce_time as produceTime,car_type as carType from t_car where car_type = #{carType}
      2. 上面这个SQL语句结果如下:
      3. select id,car_num as carNum,brand,guide_price as guidePrice,produce_time as produceTime,car_type as carType from t_car where car_type = "电车"
   2. ${}
      1. select id,car_num as carNum,brand,guide_price as guidePrice,produce_time as produceTime,car_type as carType from t_car where car_type = ${carType}
      2. 上面这个SQL语句结果如下:
      3. select id,car_num as carNum,brand,guide_price as guidePrice,produce_time as produceTime,car_type as carType from t_car where car_type = 电车
   3. 可看到${}得到的值直接拼接到sql语句中了,没加引号
   4. #{}底层是先对SQL语句进行编译,然后给SQL语句的占位符问号?传值,可避免SQL注入的风险
   5. ${}底层则是先对Sql语句进行拼接,然后对SQL语句进行编译,存在SQL注入风险
   6. 所以如果要以字符串的形式拼接到SQL语句中用#{},如果以SQL语句关键字的形式拼接到SQL语句中则使用${}
2. 批量删除的SQL语句有两种写法:
   1. delete from xxxxxxxxx where xxxx or xxxxxx
   2. delete from xxxxxx where id in (1,2,3) 这种情况应该使用${}接收参数
3. 模糊查询:like
   1. '%${brand}%'
   2. concat('%',#{brand},'%')
   3. "%"#{brand}"%"
4. mybatis-config.xml文件中的mappers标签
   1. mapper标签除了resource和url属性外还有class属性,<mapper class="com.powernode.mybatis.mapper.CarMapper"></mapper>会导致mybatis去com/powernode/mybatis/mapper目录下查找CarMapper.xml文件, 适用于xml文件跟java文件(打包之后)放到一起的情形,可以在java/com/powernode.....目录中,也可在resources/com/powernode.....目录中,如果有java/a.txt以及resources/b.txt,那么在target目录下可发现a.txt和b.txt都放到类的根路径下了,之所以分成两个不同的目录只是maven在开发阶段为了方便我们
   2. mappers标签下还可以直接<package name="com.powernode.mybatis.mapper"></package>,这样这个包下所有的xml文件都会被包括进来,这是最常用的方法
5. 别名机制
   1. 比如一个xxxMapper.xml文件中有大量的查询语句,每个select都要写一遍resultType,我可以为这个字符串设置一个别名, 然后在xml标签的属性中引用它
   2. 不区分大小写,具体参照mybatis-config.xml以及CarMapper.xml
   3. namespace不能起别名,只能写全限定接口名
   4. package标签中包括的所有类全部自动起别名,别名就是类简名,不区分大小写
6. 获取在事务提交之前自动生成的主键值(这个主键值可能在其他要插入的数据中用到,否则就只能先提交事务然后从数据库查询,这破坏了一个service事务完整性)
   1. 具体参照testGetPrimaryKeyBeforeCommitTransaction测试程序以及CarMapper.xml

