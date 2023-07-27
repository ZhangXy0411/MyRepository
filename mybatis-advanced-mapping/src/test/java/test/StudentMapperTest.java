package test;

import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import utils.SqlSessionUtil;

public class StudentMapperTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());
        sqlSession.close();
    }
    @Test
    public void testSelectByIdAssociation(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(4);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void testSelectByIdStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student=mapper.selectByIdStep1(5);
        System.out.println(student.getSname());
        sqlSession.close();
    }
}
