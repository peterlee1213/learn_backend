import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.powernode.utils.SqlSessionUtil;

public class TestStartUp {
    @Test
    /**
     * 测试第一个mybatis程序
     */
    public void testMyFirstMybatis() {
        SqlSession mySession = null;
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml"));
            mySession = sqlSessionFactory.openSession();
            int insert = mySession.insert("insertCar");
            // 默认mybatis开启事务，即执行完sql语句之后通过commit提交事务，数据库中才会生效
            mySession.commit();
            System.out.println(insert);
        } catch (IOException e) {
            if (mySession != null) {
                // 遇到异常回滚事务
                mySession.rollback();
            }
        } finally {
            if (mySession != null) {
                // 关闭事务(释放资源)
                mySession.close();
            }
        }

    }

    @Test
    /**
     * 使用封装的工具类创建对象
     */
    public void testUtil() {
        SqlSession sqlSession = SqlSessionUtil.get();
        if (sqlSession != null) {
            int count = sqlSession.insert("insertCar");
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
