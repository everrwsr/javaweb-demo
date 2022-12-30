package mapper;

import pojo.User;

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
}
