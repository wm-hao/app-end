package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.DepartHospitalRel;
import zhh.ap.dao.DepartHospitalRelMapper;
import zhh.ap.service.IAppDepartHospitalRelSV;

import javax.annotation.Resource;
import java.util.List;

@Service("appDepartHospitalSV")
public class AppDepartHospitalRelSVImpl implements IAppDepartHospitalRelSV{
    @Resource
    private DepartHospitalRelMapper dao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DepartHospitalRel record) {
        return dao.insert(record);
    }

    @Override
    public DepartHospitalRel selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public List<DepartHospitalRel> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DepartHospitalRel record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public List<DepartHospitalRel> selectByDepartmentCode(String departmentCode) {
        return dao.selectByDepartmentCode(departmentCode);
    }

    @Override
    public List<DepartHospitalRel> selectByHospitalCode(String hospitalCode) {
        return dao.selectByHospitalCode(hospitalCode);
    }
}
