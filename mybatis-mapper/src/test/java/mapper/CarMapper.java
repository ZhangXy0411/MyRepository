package mapper;

import org.apache.ibatis.annotations.MapKey;
import pojo.Car;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    public int insertCar(Car car);

    /**
     * 查询所有的Car，返回一个大Map集合
     */
    @MapKey("id")
    Map<Long, Map<String,Object>> selectAllRetMap();

    List<Car> selectAllAutoMapper();

    /**
     * 获取car的总记录条数
     * @return
     */
    Long selectTotal();

}
