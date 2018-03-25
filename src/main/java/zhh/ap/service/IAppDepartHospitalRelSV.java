package zhh.ap.service;

import zhh.ap.bean.DepartHospitalRel;

import java.util.List;

public interface IAppDepartHospitalRelSV {

    int deleteByPrimaryKey(Integer id);

    int insert(DepartHospitalRel record);

    DepartHospitalRel selectByPrimaryKey(Integer id);

    List<DepartHospitalRel> selectAll();

    int updateByPrimaryKey(DepartHospitalRel record);

    List<DepartHospitalRel> selectByDepartmentCode(String departmentCode);

    List<DepartHospitalRel> selectByHospitalCode(String hospitalCode);
}
