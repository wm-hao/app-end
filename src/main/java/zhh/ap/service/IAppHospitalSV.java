package zhh.ap.service;

import zhh.ap.bean.Hospital;

import java.util.List;

public interface IAppHospitalSV {
    List<Hospital> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int updateByPrimaryKey(Hospital record);

    Hospital selectByPrimaryKey(Integer id);

}
