import mapper.StudentMapper;
import maybatisUtil.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public class StudentMapperTest {
    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("李四");
        students.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date birth=sdf.parse("2023-05-12");
        List<Student> students = mapper.selectByBrith(birth);
        students.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Character sex = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(sex);
        students.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertStudentByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("姓名","赵六");
        map.put("年龄",20);
        map.put("性别",'男');
        map.put("生日",new Date());
        map.put("身高",1.81);

        mapper.insertStudentByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张三", '男');
        students.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByNameAndSex2Param(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex2("张三", '男');
        students.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }
}
