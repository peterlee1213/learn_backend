import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.CarMapper;
import com.powernode.pojo.Car;
import com.powernode.util.SqlSessionUtil;

public class TestTricks {
    @Test
    /**
     * 测试#{}和${}的区别
     */
    public void testSelectByCarType() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByCarType("电车");
        System.out.println(list.toString());
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 测试ASC或者DESC
     * 在什么场景下需要通过${}直接拼接SQL语句
     * 需要直接将字符串拼接到SQL语句中且不带引号时
     */
    public void testAscOrDesc() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectAllByAscOrDesc("desc");
        System.out.println(list.toString());
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 测试where id in (1,2,3.....)这种sql语句在mybatis中的写法
     */
    public void testWhereInClause() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int deleteBarch = mapper.deleteBarch("12,13");
        System.out.println(deleteBarch);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 使用 where xxx like xxx进行模糊查询
     */
    public void testWhereLikeClause() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByBrandLike("%2020%");
        System.out.println(list.toString());
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 在提交事务之前获取插入的某条数据的主键值
     */
    public void testGetPrimaryKeyBeforeCommitTransaction() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "999", "本田", 11.11, "3333-11-11", "蒸汽机");
        Object result = mapper.insertCarAndgetGeneratedKey(car);
        System.out.println(result);
        System.out.println(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
