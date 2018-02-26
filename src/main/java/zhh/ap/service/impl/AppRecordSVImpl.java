package zhh.ap.service.impl;

import zhh.ap.bean.AppointmentRecord;
import zhh.ap.dao.AppointmentRecordMapper;
import zhh.ap.service.IAppRecordSV;

import javax.annotation.Resource;
import java.util.List;

public class AppRecordSVImpl implements IAppRecordSV {
    @Resource
    private AppointmentRecordMapper dao;

    @Override
    public List<AppointmentRecord> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AppointmentRecord AppointmentRecord) {
        return dao.insert(AppointmentRecord);
    }

    @Override
    public int updateByPrimaryKey(AppointmentRecord AppointmentRecord) {
        return dao.updateByPrimaryKey(AppointmentRecord);
    }

    @Override
    public AppointmentRecord selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
