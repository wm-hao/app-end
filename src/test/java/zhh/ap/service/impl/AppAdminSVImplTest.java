package zhh.ap.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zhh.ap.bean.Admin;
import zhh.ap.bean.Doctor;
import zhh.ap.service.IAppAdminSV;
import zhh.ap.service.IAppDoctorSV;
import zhh.ap.util.security.SecurityUtil;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class AppAdminSVImplTest {

    @Autowired
    private ApplicationContext ctx;

    private IAppAdminSV sv;
    private IAppDoctorSV doctorSV;

    @Before
    public void before() {
        sv = (IAppAdminSV) ctx.getBean("appAdminSV");
        doctorSV = (IAppDoctorSV) ctx.getBean("appDoctorSV");
    }

    @Test
    public void selectAll() throws Exception {
        List<Admin> admins = sv.selectAll();
        System.out.println("Is Null :"  + (null == admins));
        for (Admin admin : admins) {
            System.out.println(admin.getName());
        }
    }

    @Test
    public void deleteByPrimaryKey() {
        System.out.println(sv.deleteByPrimaryKey(1));
    }

    @Test
    public void insert() {
        Admin admin = new Admin();
        admin.setAdminCode("000002");
        admin.setName("朱浩浩2");
//        admin.setAdminType(0);
//        admin.setId(2);
        admin.setPassword("hellopwd");
        System.out.println("Insert Into Admin: " + sv.insert(admin));
    }

    @Test
    public void updateByPrimaryKey() {
        Admin admin = new Admin();
//        admin.setId(2);
        admin.setPassword(SecurityUtil.getSHA256Str("hellopwd"));
        System.out.println("Update Admin:" + sv.updateByPrimaryKey(admin));
    }

    @Test
    public void selectByPrimaryKey() {
        Admin admin = sv.selectByPrimaryKey(2);
        // NullPointer Exception
        System.out.println(admin.getName() + " phone number :" + admin.getPassword());
    }

    @Test
    public void testSelectAndUpdate() {
        Admin admin = sv.selectByPrimaryKey(3);
        admin.setAge(10);
        admin.setPassword(SecurityUtil.getSHA256Str("niaoxry"));
        System.out.println("Query And Update :" + sv.updateByPrimaryKey(admin));
    }
    @Test
    public void testInsert() {
        Doctor doctor = doctorSV.selectByIdCard("12312312312312");
        doctor.setPassword(SecurityUtil.getSHA256Str("zhuhh123"));
        doctorSV.updateByPrimaryKey(doctor);
    }

    @Test
    public void test() {
        System.out.println(doctorSV.validate("13210011001","zhuhh"));
    }
}