package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.User;
import zhh.ap.dao.UserMapper;
import zhh.ap.service.IAppUserSV;
import zhh.ap.util.security.SecurityUtil;

import javax.annotation.Resource;
import java.util.List;

@Service("appUserSV")
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

    @Override
    public User selectByPhoneNumber(String phoneNumber) {
        return dao.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public boolean validate(String phoneNumber, String password) {
        User user = selectByPhoneNumber(phoneNumber);
        return SecurityUtil.getSHA256Str(password).equals(user == null?"":user.getPassword());
    }

    @Override
    public User selectByPhoneNumberAndEmail(String phoneNumber, String email) {
        return dao.selectByPhoneNumberAndEmail(phoneNumber, email);
    }

    @Override
    public User selectUserInfoByIdCard(String idCard) {
        return dao.selectUserInfoByIdCard(idCard);
    }
}
