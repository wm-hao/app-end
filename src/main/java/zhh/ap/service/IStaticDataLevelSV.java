package zhh.ap.service;

import zhh.ap.bean.StaticDataLevel;

import java.util.List;

public interface IStaticDataLevelSV {
    List<StaticDataLevel> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(StaticDataLevel record);

    int updateByPrimaryKey(StaticDataLevel record);

    StaticDataLevel selectByPrimaryKey(Integer id);

    StaticDataLevel selectByCode(String code);

}
