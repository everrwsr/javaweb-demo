package com.everr;

import com.everr.mapper.BrandMapper;
import com.everr.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * description :
 *
 * @author: everr
 * @date: 2022/12/30 21:48
 **/
public class MybatisTest {
@Test
    public void testSelectAll() throws IOException {
        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);
        //释放
        sqlSession.close();
    }
}
