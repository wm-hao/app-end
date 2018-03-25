package zhh.ap.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.*;
import zhh.ap.service.*;
import zhh.ap.util.TimeUtil;
import zhh.ap.valuebean.AppConstants;
import zhh.ap.valuebean.HttpReqResult;
import zhh.ap.valuebean.RespRecord;
import zhh.ap.valuebean.UserLoginInfo;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    private static transient Log _log = LogFactory.getLog(RecordController.class);
    @Resource(name = "appRecordSV")
    private IAppRecordSV recordSV;
    @Resource(name = "appScheduleSV")
    private IAppScheduleSV scheduleSV;
    @Resource(name = "appHospitalSV")
    private IAppHospitalSV hospitalSV;
    @Resource(name = "appDepartmentSV")
    private IAppDepartmentSV departmentSV;
    @Resource(name = "appDoctorSV")
    private IAppDoctorSV appDoctorSV;

    @RequestMapping(value = "selectByUserCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<RespRecord> selectByUserCode(@RequestBody UserLoginInfo userLoginInfo) {
        List<AppointmentRecord> records = recordSV.selectByUsercode(userLoginInfo.getUserCode());
        return getUiList(records);
    }

    @RequestMapping(value = "add", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public HttpReqResult add(@RequestBody AppointmentRecord record) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        reqResult.setData(AppConstants.APPOINT_SUCCESS);
        Schedule schedule = scheduleSV.seletByHospitalDepartDay(record.getHospitalCode(), record.getDepartmentCode(), record.getAppointTime());
        AppointmentRecord record1 = recordSV.selectByUserAndTime(record.getUserCode(), record.getAppointTime());
        Hospital hospital = hospitalSV.selectByCode(record.getHospitalCode());
        Department department = departmentSV.selectByCode(record.getDepartmentCode());
        String currentDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if(null != record1) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您已存在" + record.getAppointTime() + "的预约记录，不能预约！");
        } else if(null == hospital) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您填写的的医院编码" + record.getHospitalCode() + "，不存在！");
        } else if(null == department) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您填写的的科室编码" + record.getDepartmentCode() + "，不存在！");
        } else if(Long.valueOf(currentDateStr) > Long.valueOf(record.getAppointTime()) ) {
            reqResult.setResult(HttpReqResult.FAIL);
            reqResult.setData("您填写的的预约日期" + record.getAppointTime() + "，已经是过去了！");
        } else {
            try {
                if (null != schedule) {
                    if (schedule.getLeftLimit() > 0) {
                        reqResult.setData(AppConstants.APPOINT_SUCCESS);
                        record.setHospitalName(hospital.getName());
                        record.setHospital(hospital.getName());
                        record.setDepartmentName(department.getName());
                        record.setDepartment(department.getName());
                        record.setOptTime(TimeUtil.getYYYYMMDDHHMMSS(new Date()));
                        record.setDoctorName("值班医生");
                        record.setDoctorCode("9999");
                        if(StringUtils.isNotBlank(record.getDoctorCode())) {
                            Doctor doctor = appDoctorSV.selectByColumn("doctor_code", record.getDoctorCode());
                            if(null != doctor) {
                                if(StringUtils.isNotBlank(doctor.getName())) {
                                    record.setDoctorName(doctor.getName());
                                    record.setDoctorCode(doctor.getDoctorCode());
                                }
                            }
                        }
                        recordSV.insert(record);
                        schedule.setLeftLimit(schedule.getLeftLimit() - 1);
                        scheduleSV.updateByPrimaryKey(schedule);
                    } else {
                        reqResult.setData(AppConstants.APPOINT_OVERLIMIT);
                    }
                } else {
                    reqResult.setResult(HttpReqResult.FAIL);
                    reqResult.setData("你要预约的日期没有安排！");
                }
            } catch (Exception e) {
                _log.error(e);
                reqResult.setResult(HttpReqResult.FAIL);
            }
        }
        return reqResult;
    }

    @RequestMapping(value = "selectByDoctorCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<RespRecord> selectByDoctorCode(@RequestBody UserLoginInfo userLoginInfo) {
        List<AppointmentRecord> records = recordSV.selectByDoctorCode(userLoginInfo.getDoctorCode());
        List<AppointmentRecord> records1 = recordSV.selectByDoctorCode("9999");
        List<AppointmentRecord> results = new ArrayList<>();
        if(!records.isEmpty()) {
            for(AppointmentRecord record : records) {
                results.add(record);
            }
        }
        if(!records1.isEmpty()) {
            for(AppointmentRecord record : records1) {
                results.add(record);
            }
        }
        return getUiList(results);
    }

    private List<RespRecord> getUiList(List<AppointmentRecord> records) {
        List<RespRecord> results = new ArrayList<>();
        if(null != records) {
            for (AppointmentRecord record : records) {
                RespRecord result = new RespRecord();
                result.setAppointmentTime(TimeUtil.getYYYYMMDDFromStr(record.getAppointTime()));
                result.setDepartmentName(record.getDepartmentName());
                result.setDoctorName(record.getDoctorName());
                result.setFailReason(record.getFailReason());
                result.setHospitalName(record.getHospitalName());
                result.setUserName(record.getUserName());
                result.setState(StringUtils.isBlank(record.getFinishTime()) ? AppConstants.RECORD_STATE_WAITING : (StringUtils.isBlank(record.getFailReason()) ? AppConstants.RECORD_STATE_FINISHED : AppConstants.RECORD_STATE_DISCARD));
                results.add(result);
            }
        }
        return results;
    }

    @RequestMapping(value = "/selectAll", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public List<AppointmentRecord> selectAll() throws Exception {
        _log.info("查询所有预约");
        List<AppointmentRecord> records = recordSV.selectAll();
        return records;
    }

    @RequestMapping(value = "/deleteByIdcard", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult deleteByIdcard(@RequestBody AppointmentRecord record) throws Exception {
        return new HttpReqResult(recordSV.deleteByPrimaryKey(record.getId())==1?HttpReqResult.SUCCESS:HttpReqResult.FAIL);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody AppointmentRecord record){
        return new HttpReqResult(recordSV.updateByPrimaryKey(record)==1?HttpReqResult.SUCCESS:HttpReqResult.FAIL);
    }

}
