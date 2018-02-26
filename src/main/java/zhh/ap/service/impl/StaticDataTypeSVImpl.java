package zhh.ap.service.impl;

import zhh.ap.bean.StaticDataType;
import zhh.ap.dao.StaticDataTypeMapper;
import zhh.ap.service.IStaticDataTypeSV;

import javax.annotation.Resource;
import java.util.List;

public class StaticDataTypeSVImpl implements IStaticDataTypeSV {
    @Resource
    private StaticDataTypeMapper dao;

    @Override
    public List<StaticDataType> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StaticDataType record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(StaticDataType record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public StaticDataType selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
