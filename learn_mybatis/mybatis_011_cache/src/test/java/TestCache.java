import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.CarMapper;
import com.powernode.pojo.Car;
import com.powernode.utils.SqlSessionUtil;

public class TestCache {

    /**
     * 测试一级缓存
     * 可看到多个sql语句只执行了一次, 在debug console中可看到
     */
    @Test
    public void testCacheLevelOne() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car selectById = mapper.selectById(1L);
        Car selectById1 = mapper.selectById(1L);
        Car selectById2 = mapper.selectById(1L);
        Car selectById3 = mapper.selectById(1L);
        Car selectById4 = mapper.selectById(1L);
        sqlSession.close();
        SqlSessionUtil.close();
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testCacheLevelTwo() {
        SqlSession sqlSession = SqlSessionUtil.sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car selectById = mapper.selectById2(1L);
        sqlSession.close();

        System.out.println("二级缓存生效");
        SqlSession sqlSession1 = SqlSessionUtil.sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Car selectById1 = mapper1.selectById2(1L);
        sqlSession.close();
    }
}
