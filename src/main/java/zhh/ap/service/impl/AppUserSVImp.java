package zhh.ap.service.impl;

import zhh.ap.bean.User;
import zhh.ap.dao.UserMapper;
import zhh.ap.service.IAppUserSV;

import javax.annotation.Resource;
import java.util.List;

public class AppUserSVImp implements IAppUserSV {
    @Resource
    private UserMapper dao;

    @Override
    public List<User> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
