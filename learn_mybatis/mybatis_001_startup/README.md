mybatis的配置文件
1. 一个mybatis核心配置文件，可随意命名（最好是mybatis-config.xml）,可放在任何目录（最好放在类的根路径下）
2. 多个XxxxMapper.xml（通常是一个表对应一个），这个文件是专门用来编写sql语句的配置文件

怎么使用mybatis
1. 创建SqlSessionFactoryBuilder, 它负责创建SqlSessionFactory，每个SqlSessionFactory对应一个数据库
2. 通过SqlSessionFactory可创建一个SqlSession对象，每个SqlSession对象应该负责一整个业务流程的所有增删改查（业务结束了应该close session）

几个小细节
1. sql语句末尾的分号可有可无

mybatis集成日志组件
常用的: SLF4J, LOG4J 去官网查找信息
SLF只要在类的根路径下创建一个logback.xml配置文件以及在pom中引入其依赖就可以了,不需要多余的配置了