package zhh.ap.service;

import zhh.ap.bean.StaticDataType;

import java.util.List;

public interface IStaticDataTypeSV {
    List<StaticDataType> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(StaticDataType record);

    int updateByPrimaryKey(StaticDataType record);

    StaticDataType selectByPrimaryKey(Integer id);

}
