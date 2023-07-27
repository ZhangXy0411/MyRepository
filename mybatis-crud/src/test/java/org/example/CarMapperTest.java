package org.example;

import org.example.maybatisUtil.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Car;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Map<String,Object> map=new HashMap<>();
        map.put("car_num","1111");
        map.put("brand","比亚迪");
        map.put("guide_price",10.0);
        map.put("produce_time","2022-11-11");
        map.put("car_type","电车");

        int count = sqlSession.insert("insertCar", map);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarPojo(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car=new Car(null,"4444","比亚迪汉",10.00,"2023-12-12","油车");
        int count = sqlSession.insert("insertCar", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteCar", 13);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car =new Car(5L,"7894","奔驰",56.00,"2012-12-12","好车");
        int count = sqlSession.update("updateCar",car);
        System.out.println(count);
        sqlSession.close();
    }

    //查询一条
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectCar", 2);
        System.out.println(car);
        sqlSession.close();
    }

    //查询全部
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println(cars));//lambda表达式

        sqlSession.close();
    }
}
