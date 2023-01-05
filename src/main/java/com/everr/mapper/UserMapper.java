package com.everr.mapper;

import com.everr.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hanbing
 * Date: 2022-12-30
 * Time: 20:48
 */
public interface UserMapper {
    List<User> selectAll();
    @Select("select * from tb_user where id = #{id}")
    List<User> selectById(int id);
}
