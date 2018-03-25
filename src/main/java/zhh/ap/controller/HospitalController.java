package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.Hospital;
import zhh.ap.service.IAppHospitalSV;
import zhh.ap.valuebean.ReqHospital;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private static transient Log _log = LogFactory.getLog(HospitalController.class);
    @Resource(name = "appHospitalSV")
    private IAppHospitalSV hospitalSV;

    @RequestMapping(value = "/selectAll", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Hospital> selectAll() {
        _log.error("查询所有医院信息");
        return hospitalSV.selectAll();
    }

    @RequestMapping(value = "/selectByArea", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Hospital> selectByArea(@RequestBody ReqHospital reqHospital) {
        _log.error("根据地区查询医院");
        return hospitalSV.selectByArea(reqHospital.getArea());
    }

    @RequestMapping(value = "/selectByName", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Hospital> selectByName(@RequestBody ReqHospital reqHospital) {
        _log.error("根据名称模糊查询医院");
        return hospitalSV.selectByName( "%" + reqHospital.getName() + "%");
    }

    @RequestMapping(value = "/selectByLevel", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Hospital> selectByLevel(@RequestBody ReqHospital reqHospital) {
        _log.error("根据等级查询医院");
        return hospitalSV.selectByLevel(reqHospital.getLevel());
    }

    @RequestMapping(value = "/selectByCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public Hospital selectByCode(@RequestBody ReqHospital reqHospital) {
        _log.error("根据编码查询医院");
        return hospitalSV.selectByCode(reqHospital.getHospitalCode());
    }



}
