package zhh.ap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.StaticDataArea;
import zhh.ap.service.IStaticDataAreaSV;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sdArea")
@RestController
public class SDAreaController {

    @Resource(name = "staticDataAreaSV")
    private IStaticDataAreaSV staticDataAreaSV;

    @RequestMapping(value = "selectAll", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<StaticDataArea> selectAll() throws Exception {
        return staticDataAreaSV.selectAll();
    }
}
