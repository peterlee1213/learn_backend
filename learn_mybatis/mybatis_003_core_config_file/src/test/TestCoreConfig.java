import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestCoreConfig {
    @Test
    /**
     * 测试多环境下连接多个数据库
     */
    public void testMultiEnv() {
        SqlSessionFactory test = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config-nulti-env.xml"), "test");
        SqlSessionFactory prod = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config-nulti-env.xml"), "prod");
        SqlSession testSession = test.openSession();
        SqlSession prodSession = prod.openSession();
        System.out.println(testSession.select("getOneById", 1));
        System.out.println(prodSession.select("getOneById", 1));
    }
}
