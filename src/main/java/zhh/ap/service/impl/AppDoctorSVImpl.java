package zhh.ap.service.impl;

import zhh.ap.bean.Doctor;
import zhh.ap.dao.DoctorMapper;
import zhh.ap.service.IAppDoctorSV;

import javax.annotation.Resource;
import java.util.List;

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
}
