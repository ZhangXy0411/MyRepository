package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /**
     * Param注解
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex2(@Param("name") String name, @Param("sex")Character sex);

    /**
     * 多参数查询
     * 根据name和sex查询学生信息
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex(String name,Character sex);

    /**
     * 保存学生信息，通过map参数，以下是单个参数，但不是简单类型是map集合
     * @param map
     * @return
     */
    int insertStudentByMap(Map<String,Object> map);


    /**
     * 一个参数查询
     */
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBrith(Date birth);
    List<Student> selectBySex(Character sex);
}
