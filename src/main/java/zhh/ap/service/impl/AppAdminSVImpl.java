package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Admin;
import zhh.ap.dao.AdminMapper;
import zhh.ap.service.IAppAdminSV;
import zhh.ap.util.security.SecurityUtil;

import javax.annotation.Resource;
import java.util.List;

@Service("appAdminSV")
public class AppAdminSVImpl implements IAppAdminSV {
    @Resource
    private AdminMapper dao;

    @Override
    public List<Admin> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public boolean validate(String phoneNumber, String password) {
        Admin admin = selectByPhoneNumber(phoneNumber);
        return SecurityUtil.getSHA256Str(password).equals(admin == null?"":admin.getPassword());
    }

    @Override
    public Admin selectByPhoneNumberAndEmail(String phoneNumber, String email) {
        return dao.selectByPhoneNumberAndEmail(phoneNumber, email);
    }

    @Override
    public Admin selectByIdCard(String idCard) {
        return dao.selectByIdCard(idCard);
    }

    @Override
    public Admin selectByPhoneNumber(String phoneNumber) {
        return dao.selectByPhoneNumber(phoneNumber);
    }
}
