package zhh.ap.service;

import zhh.ap.bean.Department;

import java.util.List;

public interface IAppDepartmentSV {
    List<Department> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int updateByPrimaryKey(Department record);

    Department selectByPrimaryKey(Integer id);
}
