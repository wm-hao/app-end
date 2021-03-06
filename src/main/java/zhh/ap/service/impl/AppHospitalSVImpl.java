package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Hospital;
import zhh.ap.dao.HospitalMapper;
import zhh.ap.service.IAppHospitalSV;

import javax.annotation.Resource;
import java.util.List;

@Service("appHospitalSV")
public class AppHospitalSVImpl implements IAppHospitalSV {
    @Resource
    private HospitalMapper dao;

    @Override
    public List<Hospital> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Hospital record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Hospital record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Hospital selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public List<Hospital> selectByArea(String area) {
        return dao.selectByArea(area);
    }

    @Override
    public List<Hospital> selectByName(String area) {
        return dao.selectByName(area + "%");
    }

    @Override
    public List<Hospital> selectByLevel(String level) {
        return dao.selectByLevel(level);
    }

    @Override
    public Hospital selectByCode(String code) {
        return dao.selectByCode(code);
    }
}
