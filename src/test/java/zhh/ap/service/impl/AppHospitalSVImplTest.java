package zhh.ap.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zhh.ap.bean.Hospital;
import zhh.ap.service.IAppHospitalSV;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class AppHospitalSVImplTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testSelectAll() throws Exception{
        IAppHospitalSV hospitalSV = (IAppHospitalSV) ctx.getBean("appHospitalSV");
        List<Hospital> allHospital = hospitalSV.selectAll();
        Assert.assertNotNull(allHospital);
        for(Hospital Hospital : allHospital) {
            System.out.println(Hospital.getName());
        }
    }

    @Test
    public void selectByName() {
        IAppHospitalSV hospitalSV = (IAppHospitalSV) ctx.getBean("appHospitalSV");
        String name = "北京";
        List<Hospital> allHospital = hospitalSV.selectByName(name);
        Assert.assertNotNull(allHospital);
        for(Hospital Hospital : allHospital) {
            System.out.println(Hospital.getName());
        }
    }


}