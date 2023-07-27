import mapper.CarMapper;
import maybatisUtil.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarMpperTest {
    @Test
    public void testSelectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        /*List<Car> cars1=mapper.selectByMultiCondition("丰田",20.0,"新能源");*/
        List<Car> cars=mapper.selectByMultiCondition("",null,"");
        cars.forEach(car -> System.out.println(car));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByMultiConditionWithWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars=mapper.selectByMultiConditionWithWhere("丰田",20.0,"新能源");
        /*List<Car> cars=mapper.selectByMultiConditionWithWhere("",null,"");*/
        cars.forEach(car -> System.out.println(car));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
//        List<Car> cars=mapper.selectByMultiConditionWithTrim("丰田",20.0,"新能源");
        List<Car> cars=mapper.selectByMultiConditionWithWhere("丰田",20.0,"");
        cars.forEach(car -> System.out.println(car));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(41L,null,"丰田霸道",null,null,null);
        mapper.updateWithSetById(car);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectWithChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //List<Car> cars = mapper.selectWithChoose("丰田霸道", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", null, "2000-10-10");
        List<Car> cars = mapper.selectWithChoose("", null, "");
        cars.forEach(car -> System.out.println(car));

        sqlSession.close();

    }
    @Test
    public void testDeleteBatchByForeach(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids={41L,42L,43L};
        int count=mapper.deleteByIds(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car1 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car2 = new Car(null, "2002", "梅赛德斯", 100.0, "1998-10-11", "燃油车");
        Car car3 = new Car(null, "2003", "帕拉梅拉", 100.0, "1998-10-11", "燃油车");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int count = mapper.insertBatch(cars);
        System.out.println("插入了几条记录=>" + count);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();
    }
    @Test
    public void testDeleteByIds2(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteByIds2(new Long[]{40L, 41L, 42L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();
    }
}

