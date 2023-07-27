package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/*
*mybatis工具类
*/
public class SqlSessionUtil {

    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*public static SqlSession openSession(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //sqlSessionFactory对象，一个sqlSessionFactory对应一个environment，一个environment通常对应一个数据库
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }*/
    /*
    获取回话对象
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

}
