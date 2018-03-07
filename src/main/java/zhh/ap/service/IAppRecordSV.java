package zhh.ap.service;

import zhh.ap.bean.AppointmentRecord;

import java.util.List;

public interface IAppRecordSV {
    List<AppointmentRecord> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(AppointmentRecord record);

    int updateByPrimaryKey(AppointmentRecord record);

    AppointmentRecord selectByPrimaryKey(Integer id);

    List<AppointmentRecord> selectByUsercode(String userCode);

}
