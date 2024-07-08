import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.mapper.CarMapper;
import com.powernode.pojo.Car;
import com.powernode.util.SqlSessionUtil;

public class TestCRUDWithProxy {
    @Test
    /**
     * 测试insert
     */
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.insert(new Car(null, "12345", "只想", 34.56, "2033-11-11", "h火车"));
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 测试delete
     */
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(14L);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 测试修改
     */
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(13L, "1111", "hhh", 11.11, "2020-02-02", "haha");
        int update = mapper.update(car);
        System.out.println(update);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 测试查一条
     */
    public void testSelectOne() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(13L);
        System.out.println(car.toString());
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    /**
     * 测试查所有
     */
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectAll();
        System.out.println(list.toString());
        SqlSessionUtil.close(sqlSession);
    }
}
