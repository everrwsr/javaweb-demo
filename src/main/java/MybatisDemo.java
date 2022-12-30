import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * description :
 *
 * @author: everr
 * @date: 2022/12/30 19:53
 **/
public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        sqlSession.selectAll("test.selectAll");
    }
}
