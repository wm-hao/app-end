package zhh.ap.service;

import zhh.ap.bean.Schedule;

import java.util.List;

public interface IAppScheduleSV {

    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    List<Schedule> selectAll();

    int updateByPrimaryKey(Schedule record);

    Schedule seletByHospitalDepartDay(String hospitalCode, String departCode, String day);
}
