package zhh.ap.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;
import zhh.ap.util.security.SecurityUtil;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class AppUserSVImpTest {

    @Autowired
    private ApplicationContext ctx;

    private IAppUserSV userSV;


    @Before
    public void getUserSV() {
        userSV = ctx.getBean("appUserSV", IAppUserSV.class);
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setPassword("zhh");
        user.setPhoneNumber("13218020018");
        userSV.insert(user);
    }

    @Test
    public void updateByPrimaryKey() {
        User user = userSV.selectUserInfoByIdCard("3406");
        user.setPassword(SecurityUtil.getSHA256Str("zhuhh"));
        userSV.updateByPrimaryKey(user);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void validate() {
        String phoneNumber = "13218020018";
        String password = "zhh";
        System.out.println("validate user:" + userSV.validate(phoneNumber, password));
    }

    @Test
    public void selectByPhoneNumber() {
//        String phoneNumber = "132180200181";
        String phoneNumber = null;
        System.out.println(userSV.selectByPhoneNumber(phoneNumber).getPassword());
    }

    @Test
    public void selectByPhoneNumberAndEmail() {
        String phone = "132180200181";
        String email = "448826602@qq.com";
        System.out.println(userSV.selectByPhoneNumberAndEmail(phone, email));
    }
}