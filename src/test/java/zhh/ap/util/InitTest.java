package zhh.ap.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zhh.ap.service.IAppHospitalSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class InitTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testLazyInit() throws Exception {
        IAppHospitalSV sv = ctx.getBean("appHospitalSV", IAppHospitalSV.class);
        sv.selectAll();
        Thread.sleep(2000);
        System.out.println("睡醒了");
    }

}
