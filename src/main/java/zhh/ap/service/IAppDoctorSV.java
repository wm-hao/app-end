package zhh.ap.service;

import zhh.ap.bean.Doctor;

import java.util.List;

public interface IAppDoctorSV {
    List<Doctor> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int updateByPrimaryKey(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

}
