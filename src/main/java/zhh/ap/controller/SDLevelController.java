package zhh.ap.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.StaticDataLevel;
import zhh.ap.service.IStaticDataLevelSV;
import zhh.ap.valuebean.ReqStaticData;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sdlevel")
public class SDLevelController {
    @Resource(name = "staticDataLevelSV")
    private IStaticDataLevelSV staticDataLevelSV;

    @RequestMapping(value = "selectAll", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<StaticDataLevel> selectAll() throws Exception {
        return staticDataLevelSV.selectAll();
    }

    @RequestMapping(value = "selectByCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public StaticDataLevel selectByCode(@RequestBody ReqStaticData reqStaticData) throws Exception {
        return staticDataLevelSV.selectByCode(reqStaticData.getCode());
    }

}
