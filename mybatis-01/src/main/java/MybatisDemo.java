
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisDemo {
    public static void main(String[] args) throws Exception{
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        /*Resources.getResourceAsStream("mybatis-config.xml");
        CLassLoader.getSystemCLassLoader().getResourceAsStream("mybatis-config.xml");*/
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行SQL语句
        int count = sqlSession.insert("insertCar");

        System.out.println("插入数据的条数:"+count);

        //mybatis默认不自动提交，需要手动提交
        sqlSession.commit();
    }
}
