import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.powernode.bean.User;

public class TestJDBC {
    @Test
    /**
     * 连接数据库
     */
    public void testJDBCConn() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(bean);
    }

    @Test
    /**
     * 插入
     */
    public void testJDBCInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into user(real_name,age) value(?,?)";
        // 在jdbcTemplate中只要是增删改都是update方法, 第一个参数是sql语句, 后面的参数是替换sql语句中的?的
        bean.update(sql, "赵六", 77);
    }

    @Test
    /**
     * 更新
     */
    public void testJDBCUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        /**
         * 注意:
         * 问号只能用来代替值而非字段名, 否则会报错
         */
        String sql = "update user set real_name = ? where id = ?";
        bean.update(sql, "amy", 2);
    }

    @Test
    /**
     * 查询一条记录
     */
    public void testRetrieveOneItem() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from user where id = ?";
        /**
         * 第二个参数是一个对象,告诉jdbc查询后的结果赋值到那个class上
         * 注意: real_name可以被BeanPropertyRowMapper映射到realName变量上
         */
        User queryForObject = bean.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 3);
        System.out.println(queryForObject);
    }

    @Test
    /**
     * 查询多条记录
     */
    public void testRetrieveMultipleItems() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from user";
        List<User> queryForObject = bean.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(queryForObject);
    }

    @Test
    /**
     * 查询一个数字
     */
    public void testRetrieveCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(1) from user";
        Integer queryForObject = bean.queryForObject(sql, int.class);
        System.out.println(queryForObject);
    }

    @Test
    /**
     * 插入多条记录
     */
    public void testInsertMultiple() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into user(real_name, age) values(?,?)";
        Object[] obj1 = { "小明", 20 };
        Object[] obj2 = { "小花", 21 };

        List<Object[]> list = new ArrayList<>();

        list.add(obj1);
        list.add(obj2);

        int[] count = bean.batchUpdate(sql, list);

        System.out.println(Arrays.toString(count));
    }

    @Test
    /**
     * 批量删除
     */
    public void testGroupDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate bean = context.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "delete from user where id = ?";

        Object[] obj1 = { 1 };
        Object[] obj2 = { 2 };

        List<Object[]> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        int[] batchUpdate = bean.batchUpdate(sql, list);
        System.out.println(Arrays.toString(batchUpdate));

    }
}
