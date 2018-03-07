package zhh.ap.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zhh.ap.bean.AppointmentRecord;
import zhh.ap.service.IAppRecordSV;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class AppRecordSVImplTest {

    @Autowired
    private ApplicationContext ctx;
    private IAppRecordSV sv;

    @Before
    public void before() {
        sv = ctx.getBean("appRecordSV", IAppRecordSV.class);
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        AppointmentRecord record = new AppointmentRecord();
        record.setAppointTime("20180202164222");
        record.setDepartment("儿科");
        record.setDepartmentCode("1001");
        record.setDepartmentName("儿科");
        record.setDisease("测试");
        record.setHospitalName("杭州第二医院");
        record.setDoctorCode("001100001");
        record.setDoctorName("肖医生");
        record.setFinishTime("20180202170012");
        record.setHospital("杭州第一医院");
        record.setHospitalCode("0011");
        record.setOptTime("20180201151221");
        record.setUserCode("13218020018");
        record.setUserName("帅哥2");
        sv.insert(record);
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectByUsercode() {
        String userCode = "13218020018";
        String userCode1 = "";
        List<AppointmentRecord> list =  sv.selectByUsercode(userCode1);
        for(AppointmentRecord record : list) {
            System.out.println(record);
        }
    }
}