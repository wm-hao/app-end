package zhh.ap.service;

import zhh.ap.bean.User;

import java.util.List;

public interface IAppUserSV {
    List<User> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int updateByPrimaryKey(User record);

    User selectByPrimaryKey(Integer id);

    User selectByPhoneNumber(String phoneNumber);

    boolean validate(String phoneNumber, String password);

    User selectByPhoneNumberAndEmail(String phoneNumber, String email);

    User selectUserInfoByIdCard(String idCard);

}
