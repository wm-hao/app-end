package zhh.ap.service.impl;

import zhh.ap.bean.StaticDataArea;
import zhh.ap.dao.StaticDataAreaMapper;
import zhh.ap.service.IStaticDataAreaSV;

import javax.annotation.Resource;
import java.util.List;

public class StaticDataAreaSVImpl implements IStaticDataAreaSV{
    @Resource
    private StaticDataAreaMapper dao;

    @Override
    public List<StaticDataArea> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StaticDataArea record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(StaticDataArea record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public StaticDataArea selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
