package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.DepartHospitalRel;
import zhh.ap.bean.Department;
import zhh.ap.bean.Hospital;
import zhh.ap.service.IAppDepartHospitalRelSV;
import zhh.ap.service.IAppDepartmentSV;
import zhh.ap.service.IAppHospitalSV;
import zhh.ap.valuebean.ReqHospital;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/departHospitalRel")
@RestController
public class DepartHospitalRelController {

    private static transient Log _log = LogFactory.getLog(EvaluationController.class);
    @Resource(name="appDepartHospitalSV")
    private IAppDepartHospitalRelSV departHospitalRelSV;
    @Resource(name = "appHospitalSV")
    private IAppHospitalSV hospitalSV;
    @Resource(name = "appDepartmentSV")
    private IAppDepartmentSV departmentSV;

    @RequestMapping(value = "/selectByDepartmentCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Hospital> selectHospitalByDepartmentCode(@RequestBody ReqHospital reqHospital) {
        _log.error("根据科室查询医院");
        List<DepartHospitalRel> rels = departHospitalRelSV.selectByDepartmentCode(reqHospital.getDepartmentCode());
        List<Hospital> hospitals =new ArrayList<>();
        for(DepartHospitalRel rel : rels) {
            Hospital hospital = hospitalSV.selectByCode(rel.getHospitalCode());
            hospitals.add(hospital);
        }
        return hospitals;
    }

    @RequestMapping(value = "/selectByHospitalCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Department> selectByHospitalCode(@RequestBody ReqHospital reqHospital) {
        _log.error("根据科室查询医院");
        List<DepartHospitalRel> rels = departHospitalRelSV.selectByDepartmentCode(reqHospital.getDepartmentCode());
        List<Department> departments =new ArrayList<>();
        for(DepartHospitalRel rel : rels) {
            Department department = departmentSV.selectByCode(rel.getDepartmentCode());
            departments.add(department);
        }
        return departments;
    }

}
