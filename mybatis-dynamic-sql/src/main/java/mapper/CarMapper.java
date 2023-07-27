package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Car;

import java.util.List;

public interface CarMapper {
    /**
     * 批量插入
     * @param cars
     * @return
     */
    int insertBatch(@Param("cars")List<Car> cars);
    /**
     * 批量删除,foreach标签
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids")Long[] ids);
    int deleteByIds2(@Param("ids") Long[] ids);
    /**
     * 使用trim标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand,@Param("guidePrice") Double guidePrice,@Param("carType") String carType);

    /**
     * 多条件查询
     * @param brand 品牌
     * @param guidePrice 指导价
     * @param carType 汽车类型
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand,@Param("guidePrice") Double guidePrice,@Param("carType") String carType);
    /**
     * 使用where标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand,@Param("guidePrice") Double guidePrice,@Param("carType") String carType);

    /**
     * 使用set标签
     * @param car
     * @return
     */
    int updateWithSetById(Car car);

    /**
     * 使用choose when otherwise标签查询
     * @param brand
     * @param guidePrice
     * @param produceTime
     * @return
     */
    List<Car> selectWithChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("produceTime") String produceTime);
}
