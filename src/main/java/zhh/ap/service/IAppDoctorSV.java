package zhh.ap.service;

import zhh.ap.bean.Doctor;

import java.util.List;

public interface IAppDoctorSV {
    List<Doctor> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int updateByPrimaryKey(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    boolean validate(String phoneNumber, String password);

    Doctor selectByPhoneNumberAndEmail(String phoneNumber, String email);

    Doctor selectByIdCard(String idCard);

    Doctor selectByPhoneNumber(String phoneNumber);

    Doctor selectByColumn(String columnName, String value);
}
