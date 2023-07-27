import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MybatisDemo02 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSession sqlSession=null;
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession= sqlSessionFactory.openSession();
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            sqlSession.commit();
        } catch (IOException e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
