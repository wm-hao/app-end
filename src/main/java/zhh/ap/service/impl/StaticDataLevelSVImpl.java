package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.StaticDataLevel;
import zhh.ap.dao.StaticDataLevelMapper;
import zhh.ap.service.IStaticDataLevelSV;

import javax.annotation.Resource;
import java.util.List;

@Service("staticDataLevelSV")
public class StaticDataLevelSVImpl implements IStaticDataLevelSV {
    @Resource
    private StaticDataLevelMapper dao;

    @Override
    public List<StaticDataLevel> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StaticDataLevel record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(StaticDataLevel record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public StaticDataLevel selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public StaticDataLevel selectByCode(String code) {
        return dao.selectByCode(code);
    }
}
