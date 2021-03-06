package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Department;
import zhh.ap.dao.DepartmentMapper;
import zhh.ap.service.IAppDepartmentSV;

import javax.annotation.Resource;
import java.util.List;

@Service("appDepartmentSV")
public class AppDepartmentSVImpl implements IAppDepartmentSV {
    @Resource
    private DepartmentMapper dao;

    @Override
    public List<Department> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public Department selectByCode(String code) {
        return dao.selectByCode(code);
    }

    @Override
    public Department selectByName(String name) {
        return dao.selectByName(name + "%");
    }
}
