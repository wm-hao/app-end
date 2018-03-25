package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Schedule;
import zhh.ap.dao.ScheduleMapper;
import zhh.ap.service.IAppScheduleSV;

import javax.annotation.Resource;
import java.util.List;

@Service("appScheduleSV")
public class AppScheduleSVImpl implements IAppScheduleSV{
    @Resource
    private ScheduleMapper dao;

    @Override
    public List<Schedule> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Schedule Schedule) {
        return dao.insert(Schedule);
    }

    @Override
    public Schedule selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Schedule Schedule) {
        return dao.updateByPrimaryKey(Schedule);
    }

    @Override
    public Schedule seletByHospitalDepartDay(String hospitalCode, String departCode, String day) {
        return dao.seletByHospitalDepartDay(hospitalCode, departCode, day);
    }
}
