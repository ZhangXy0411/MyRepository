package mapper;

import org.apache.ibatis.annotations.MapKey;
import pojo.Car;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    public int insertCar(Car car);

    @MapKey("id")
    Map<Long, Map<String,Object>> selectAllRetMap();

    List<Car> selectAllAutoMapper();


    /**
     * 获取car的总记录条数
     * @return
     */
    Long selectTotal();
}
