package com.everr.mapper;


import com.everr.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hanbing
 * Date: 2022-12-30
 * Time: 20:48
 */
public interface BrandMapper {
    //查询所有
    public List<Brand> selectAll();

    /**
     * id 查询
     *
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 条件查询
     *
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    //List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName,@Param("brandName") String brandName);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     *
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     */
    int update(Brand brand);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(int id);


    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);
}
