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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);
        //释放
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

////封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        //  map.put("brandName",brandName);

        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql

        //List<User> users = sqlSession.selectList("test.selectAll");
        //获取mapper接口的代理对象

        //执行方法
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(map);


        System.out.println(brands);
        //释放
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSimple() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);


        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql

        //List<User> users = sqlSession.selectList("test.selectAll");
        //获取mapper接口的代理对象

        //执行方法
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        brandMapper.selectByConditionSingle(brand);


        System.out.println(brand);
        //释放
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "某人的礼物";
        String brandName = "某人";
        String description = " a stupid person ";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);


        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql

        //List<User> users = sqlSession.selectList("test.selectAll");
        //获取mapper接口的代理对象

        //执行方法
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


       brandMapper.add(brand);
Integer id = brand.getId();
        System.out.println(id);

        System.out.println(brand);
        //释放
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "某人的礼物";
        String brandName = "某人";
        String description = " a stupid person ";
        int ordered = 100;
        int id = 5;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
brand.setId(id);

        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql

        //List<User> users = sqlSession.selectList("test.selectAll");
        //获取mapper接口的代理对象

        //执行方法
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


int count = brandMapper.update(brand);
        System.out.println(count);
        //释放
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDelete() throws IOException {
        //接受参数

        int id = 5;

        //封装对象
        Brand brand = new Brand();

        brand.setId(id);

        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql

        //List<User> users = sqlSession.selectList("test.selectAll");
        //获取mapper接口的代理对象

        //执行方法
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);
        //释放
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteByIds() throws IOException {
        //接受参数

        int[] ids = {5,6};

        //1、加载mybatis配置文件，
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取sqlSession 对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);
        //释放
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
