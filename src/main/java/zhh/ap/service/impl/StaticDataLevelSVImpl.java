package zhh.ap.service.impl;

import zhh.ap.bean.StaticDataLevel;
import zhh.ap.dao.StaticDataLevelMapper;
import zhh.ap.service.IStaticDataLevelSV;

import javax.annotation.Resource;
import java.util.List;

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
}
