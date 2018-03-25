package zhh.ap.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zhh.ap.bean.Schedule;
import zhh.ap.service.IAppScheduleSV;
import zhh.ap.service.IAppUserSV;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class AppScheduleSVImplTest {

    @Autowired
    private ApplicationContext ctx;

    private IAppScheduleSV scheduleSV;


    @Before
    public void getSV() {
        scheduleSV = ctx.getBean("appScheduleSV", IAppScheduleSV.class);
    }
    @Test
    public void selectAll() {
        List<Schedule> list = scheduleSV.selectAll();
        for(Schedule schedule : list) {
            schedule.setTotalLimit(200);
            schedule.setLeftLimit(200);
            scheduleSV.updateByPrimaryKey(schedule);
        }
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
       int day = 20180311;
       String[] departs = {"SJw001","F001","EK001","EBH001","PFK001","KQK001","GK001","YK001"};
       String[] hospitals = {"000001","000002","000003","000004","000005"};
       for(String hospital: hospitals)
           for(String depart :departs) {
               for(int i=0;i<19;i++) {
                   Schedule schedule = new Schedule();
                   schedule.setAppointDay(String.valueOf(day+i));
                   schedule.setDepartmentCode(depart);
                   schedule.setHospitalCode(hospital);
                   schedule.setLeftLimit(200);
                   schedule.setTotalLimit(200);
                   scheduleSV.insert(schedule);
           }
        }
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void seletByHospitalDepartDay() {
    }
}