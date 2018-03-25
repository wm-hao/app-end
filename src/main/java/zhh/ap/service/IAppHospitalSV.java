package zhh.ap.service;

import org.apache.commons.lang3.StringUtils;
import zhh.ap.bean.Hospital;

import java.util.List;

public interface IAppHospitalSV {
    List<Hospital> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int updateByPrimaryKey(Hospital record);

    Hospital selectByPrimaryKey(Integer id);

    List<Hospital> selectByArea(String area);

    List<Hospital> selectByName(String area);

    List<Hospital> selectByLevel(String level);

    Hospital selectByCode(String code);
}
