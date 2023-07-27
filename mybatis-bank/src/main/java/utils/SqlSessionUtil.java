package utils;

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

    //全局的,服务器级别的，一个服务器一个
    private  static ThreadLocal<SqlSession> local=new ThreadLocal<>();

    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            //将sqlSession对象绑定到当前线程上
            local.set(sqlSession);
        }
        return sqlSession;
    }

    //关闭sqlSession对象，并将sqlSession从当前线程中移除
    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }

}
