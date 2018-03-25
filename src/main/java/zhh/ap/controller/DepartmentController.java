package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.Department;
import zhh.ap.service.IAppDepartmentSV;
import zhh.ap.valuebean.ReqHospital;
import zhh.ap.valuebean.ReqStaticData;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static transient Log _log = LogFactory.getLog(DepartmentController.class);
    @Resource(name = "appDepartmentSV")
    private IAppDepartmentSV departmentSV;

    @RequestMapping(value = "/selectAll", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<Department> selectAll() throws Exception{
        return departmentSV.selectAll();
    }

    @RequestMapping(value = "/selectByCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public Department selectByCode(@RequestBody ReqHospital reqHospital) throws Exception{
        return departmentSV.selectByCode(reqHospital.getDepartmentCode());
    }

    @RequestMapping(value = "/selectByName", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public Department selectByName(@RequestBody ReqHospital reqHospital) throws Exception{
        return departmentSV.selectByName(reqHospital.getDepartmentCode());
    }
}
