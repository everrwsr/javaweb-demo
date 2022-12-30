import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * description :
 *
 * @author: everr
 * @date: 2022/12/30 19:53
 **/
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);
        //释放
sqlSession.close();
    }
}
