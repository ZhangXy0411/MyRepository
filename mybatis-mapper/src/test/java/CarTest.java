import mapper.CarMapper;
import maybatisUtil.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Car;

import java.util.List;
import java.util.Map;

public class CarTest {
    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> maps = mapper.selectAllRetMap();
        System.out.println(maps);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarAutokeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "999", "凯美瑞", 30.0, "2020-10-11", "燃油车");
        int count = mapper.insertCar(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllAutoMapper(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllAutoMapper();
        cars.forEach(car -> System.out.println(car));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long total = mapper.selectTotal();
        System.out.println("总记录条数："+total);

        sqlSession.commit();
        sqlSession.close();
    }
}
