package zhh.ap.service;

import zhh.ap.bean.StaticDataArea;

import java.util.List;

public interface IStaticDataAreaSV {
    List<StaticDataArea> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(StaticDataArea record);

    int updateByPrimaryKey(StaticDataArea record);

    StaticDataArea selectByPrimaryKey(Integer id);

}
