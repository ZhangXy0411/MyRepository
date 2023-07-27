import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.CarMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Car;
import util.SqlSessionUtil;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //一定要在执行DQL语句之前开启分页功能
        int pageSize = 3;
        int pageNum = 2;
        PageHelper.startPage(pageNum,pageSize);

        List<Car> cars=mapper.selectAll();
        /*cars.forEach(car -> System.out.println(car));*/
        //封装分页信息对象new PageInfo()
        //PageInfo对象是PageHelper插件提供的，用来封装分页相关的信息的对象
        PageInfo<Car> carPageInfo = new PageInfo<>(cars,3);
        System.out.println(carPageInfo);
        sqlSession.close();
    }
    @Test
    public void testSelectByPage(){
        int pageSize = 3;
        int pageNum = 2;
        int startIndex=(pageNum - 1) * pageSize ;
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectByPage(startIndex,pageSize);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
