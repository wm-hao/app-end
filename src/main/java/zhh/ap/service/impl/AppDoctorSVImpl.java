package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Doctor;
import zhh.ap.dao.DoctorMapper;
import zhh.ap.service.IAppDoctorSV;
import zhh.ap.util.security.SecurityUtil;

import javax.annotation.Resource;
import java.util.List;

@Service("appDoctorSV")
public class AppDoctorSVImpl implements IAppDoctorSV{
    @Resource
    private DoctorMapper dao;

    @Override
    public List<Doctor> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Doctor record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Doctor record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Doctor selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public boolean validate(String phoneNumber, String password) {
        Doctor doctor = selectByPhoneNumber(phoneNumber);
        return SecurityUtil.getSHA256Str(password).equals(doctor == null?"":doctor.getPassword());
    }

    @Override
    public Doctor selectByPhoneNumberAndEmail(String phoneNumber, String email) {
        return dao.selectByPhoneNumberAndEmail(phoneNumber, email);
    }

    @Override
    public Doctor selectByIdCard(String idCard) {
        return dao.selectByIdCard(idCard);
    }

    @Override
    public Doctor selectByPhoneNumber(String phoneNumber) {
        return dao.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public Doctor selectByColumn(String columnName, String value) {
        return dao.selectByColumn(columnName, value);
    }


}
