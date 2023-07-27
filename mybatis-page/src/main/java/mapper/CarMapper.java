package mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.Car;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    /**
     * 查询所有，通过分页查询插件PageHelper来完成
     * @return
     */
    List<Car> selectAll();

    /**
     * 分页查询
     * @param startIndex 起始下标
     * @param pageSize 每页条数
     * @return
     */
    List<Car> selectByPage(@Param("startIndex") int startIndex,@Param("pageSize")int pageSize);
}
