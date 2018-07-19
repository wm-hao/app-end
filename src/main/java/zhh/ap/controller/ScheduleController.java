package zhh.ap.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.Department;
import zhh.ap.bean.Doctor;
import zhh.ap.bean.Hospital;
import zhh.ap.bean.Schedule;
import zhh.ap.service.IAppDepartmentSV;
import zhh.ap.service.IAppDoctorSV;
import zhh.ap.service.IAppHospitalSV;
import zhh.ap.service.IAppScheduleSV;
import zhh.ap.valuebean.HttpReqResult;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private static transient Log _log = LogFactory.getLog(ScheduleController.class);
    @Resource(name = "appScheduleSV")
    private IAppScheduleSV appScheduleSV;
    @Resource(name = "appDoctorSV")
    private IAppDoctorSV doctorSV;
    @Resource(name = "appHospitalSV")
    private IAppHospitalSV appHospitalSV;
    @Resource(name = "appDepartmentSV")
    private IAppDepartmentSV appDepartmentSV;

    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult delete(@RequestBody Schedule schedule) {
        return new HttpReqResult(appScheduleSV.deleteByPrimaryKey(schedule.getId()) == 1 ? HttpReqResult.SUCCESS : HttpReqResult.FAIL);
    }

    @RequestMapping(value = "/selectAll", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public List<Schedule> selectAll() throws Exception {
        _log.info("查询所有调度");
        return appScheduleSV.selectAll();
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody Schedule schedule) {
        return new HttpReqResult(appScheduleSV.updateByPrimaryKey(schedule) == 1 ? HttpReqResult.SUCCESS : HttpReqResult.FAIL);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult add(@RequestBody Schedule schedule) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        Hospital hospital = appHospitalSV.selectByCode(schedule.getHospitalCode());
        Department department = appDepartmentSV.selectByCode(schedule.getDepartmentCode());
        if(StringUtils.isNotBlank(schedule.getDoctorCode())) {
            Doctor doctor = doctorSV.selectByColumn("doctor_code",schedule.getDoctorCode());
            if(null == doctor) {
                reqResult.setResult(HttpReqResult.FAIL);
                reqResult.setData("您填写的医生编码不存在！");
                return reqResult;
            }
        }
        if(null == hospital) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您填写的医院编码不存在！");
            return reqResult;
        }
        if(null == department) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您填写的科室编码不存在！");
            return reqResult;
        }
        String currentDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if(Long.valueOf(currentDateStr) > Long.valueOf(schedule.getAppointDay()) ) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您填写的的预约日期" + schedule.getAppointDay() + "，已经是过去了！");
        }
        schedule.setLeftLimit(schedule.getTotalLimit());
        reqResult.setResult(appScheduleSV.insert(schedule) == 1 ? HttpReqResult.SUCCESS : HttpReqResult.FAIL);
        return reqResult;
    }
}
