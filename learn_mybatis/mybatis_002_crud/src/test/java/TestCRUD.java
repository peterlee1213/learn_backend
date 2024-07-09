import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.powernode.pojo.Car;
import com.powernode.utils.SqlSessionUtil;

public class TestCRUD {
    @Test
    /**
     * 插入一条记录,通过Map传参
     */
    public void insertOne() {
        SqlSession sqlSession = SqlSessionUtil.get();

        Map<String, Object> map = new HashMap<>();
        map.put("car_num", "1004");
        map.put("brand", "本田风");
        map.put("guide_price", 12.0);
        map.put("produce_time", "2222-11-11");
        map.put("car_type", "燃油车");

        int count = sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 插入一条记录,通过pojo传参
     */
    public void insertOneWithPOJO() {
        Car car = new Car(null, "1007", "文杰", 22.0, "2024-10-10", "电车");
        SqlSession sqlSession = SqlSessionUtil.get();
        int count = sqlSession.insert("insertCarPOJO", car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 根据id删除一条数据
     */
    public void deleteOneById() {
        SqlSession sqlSession = SqlSessionUtil.get();
        int deleteCount = sqlSession.delete("deleteOneById", 9);
        System.out.println(deleteCount);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 根据id更新数据
     */
    public void updateById() {
        SqlSession sqlSession = SqlSessionUtil.get();
        Car car = new Car(10L, "2222", "小米", 44.0, "2023-01-01", "电车");
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 查询一条信息
     * 查询获得的对象的属性名必须跟POJO对象的属性名完全一致,否则赋不了值
     */
    public void getOneById() {
        SqlSession sqlSession = SqlSessionUtil.get();
        Car result = (Car) sqlSession.selectOne("getOneById", 12);
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    /**
     * 查询所有信息
     */
    public void getMultipleById() {
        SqlSession sqlSession = SqlSessionUtil.get();

        List<Car> selectList = sqlSession.selectList("getMultipleById");
        System.out.println(selectList.toString());
        sqlSession.close();
    }

    @Test
    /**
     * namespace的作用
     */
    public void namespaceTest() {
        SqlSession sqlSession = SqlSessionUtil.get();
        Car result = (Car) sqlSession.selectOne("car.getOneById", 12);
        System.out.println(result);
        sqlSession.close();
    }
}
