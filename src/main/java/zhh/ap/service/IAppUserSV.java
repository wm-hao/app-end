package zhh.ap.service;

import zhh.ap.bean.User;

import java.util.List;

public interface IAppUserSV {
    List<User> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int updateByPrimaryKey(User record);

    User selectByPrimaryKey(Integer id);

}
