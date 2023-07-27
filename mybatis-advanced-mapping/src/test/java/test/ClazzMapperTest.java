package test;

import mapper.CLazzMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Clazz;
import utils.SqlSessionUtil;

public class ClazzMapperTest {
    @Test
    public void testSelectByIdCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CLazzMapper mapper = sqlSession.getMapper(CLazzMapper.class);
        Clazz clazz = mapper.selectById(1000);
        System.out.println(clazz);
        sqlSession.close();
    }

    @Test
    public void testSelectByStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CLazzMapper mapper = sqlSession.getMapper(CLazzMapper.class);
        Clazz clazz = mapper.selectByStep1(1000);
        /*System.out.println(clazz);*/
        System.out.println(clazz.getCname());
        sqlSession.close();
    }
}
