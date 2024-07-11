import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mapper.CarMapper;
import com.powernode.pojo.Car;
import com.powernode.utils.SqlSessionUtil;

public class TestPageHelper {
    @Test
    public void testPageHelper() {
        SqlSession sqlSession = SqlSessionUtil.get();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 在执行DQL语句之前开启分页功能就可以了
        int pageNum = 2;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);

        List<Car> carList = mapper.selectCarByPages();
        // System.out.println(carList);

        PageInfo<Car> pageInfo = new PageInfo<>(carList);
        System.out.println(pageInfo);
        // PageInfo含有的信息很多:
        /*
         * PageInfo{pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=16,
         * pages=6, list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6,
         * total=16, pages=6, reasonable=false, pageSizeZero=false}[Car [id=18,
         * carNum=1002, brand=丰田, guidePrice=22.0, produceTime=2020-10-10, carType=随机],
         * Car [id=19, carNum=1002, brand=丰田, guidePrice=22.0, produceTime=2020-10-10,
         * carType=随机], Car [id=20, carNum=1002, brand=丰田, guidePrice=22.0,
         * produceTime=2020-10-10, carType=随机]], prePage=1, nextPage=3,
         * isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true,
         * navigatePages=8, navigateFirstPage=1, navigateLastPage=6,
         * navigatepageNums=[1, 2, 3, 4, 5, 6]}
         * 
         */

        sqlSession.close();
        SqlSessionUtil.close();
    }
}
