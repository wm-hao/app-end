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
import zhh.ap.bean.User;
import zhh.ap.service.IAppDepartmentSV;
import zhh.ap.service.IAppDoctorSV;
import zhh.ap.service.IAppHospitalSV;
import zhh.ap.util.AppUtil;
import zhh.ap.util.email.EmailUtil;
import zhh.ap.util.security.SecurityUtil;
import zhh.ap.valuebean.*;

import javax.annotation.Resource;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private static transient Log _log = LogFactory.getLog(DoctorController.class);
    @Resource(name = "appDoctorSV")
    private IAppDoctorSV doctorSV;
    @Resource(name = "appHospitalSV")
    private IAppHospitalSV hospitalSV;
    @Resource(name = "appDepartmentSV")
    private IAppDepartmentSV departmentSV;
    @Resource(name = "emailUtil")
    private EmailUtil emailUtil;


    @RequestMapping(path = {"/validateLogin"}, method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult validateLogin(@RequestBody UserLoginInfo doctorLoginInfo) {
        _log.info("验证医生信息:" + doctorLoginInfo);
        HttpReqResult HttpReqResult = new HttpReqResult();
        boolean success = doctorSV.validate(doctorLoginInfo.getPhoneNumber(), doctorLoginInfo.getPassword());
        if(success) {
            HttpReqResult.setResult(zhh.ap.valuebean.HttpReqResult.SUCCESS);
        }else  {
            HttpReqResult.setResult(zhh.ap.valuebean.HttpReqResult.FAIL);
            HttpReqResult.setData("您输入的用户名密码不正确！");
        }
        return HttpReqResult;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult add(@RequestBody Doctor doctor) {
        HttpReqResult httpReqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        _log.info("接收到的注册医生信息:" + doctor);
        Hospital hospital = hospitalSV.selectByCode(doctor.getHospitalCode());
        if( hospital == null) {
            httpReqResult.setResult(HttpReqResult.FAIL);
            httpReqResult.setData("您注册填写的医院编码不正确！");
            return httpReqResult;
        }
        Department department = departmentSV.selectByCode(doctor.getDepartmentCode());
        if(department == null) {
            httpReqResult.setResult(HttpReqResult.FAIL);
            httpReqResult.setData("您注册填写的科室编码不正确！");
            return httpReqResult;
        }
        doctor.setDepartmentname(department.getName());
        doctor.setHospitalname(hospital.getName());
        doctor.setPassword(SecurityUtil.getSHA256Str(doctor.getPassword()));
        doctor.setSex(doctor.getSex().equals(String.valueOf(AppConstants.SEX_MAN_FLAG)) ? AppConstants.SEX_MAN_STR : AppConstants.SEX_WOMAN_STR);
        doctor.setDoctorCode(doctor.getPhoneNumber());
        doctorSV.insert(doctor);
        return httpReqResult;
    }

    @RequestMapping(value = "/selectByPhoneNumber", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public Doctor selectByPhoneNumber(@RequestBody UserLoginInfo doctorLoginInfo) {
        _log.info("根据手机号查询医生:" + doctorLoginInfo.getPhoneNumber());
        return doctorSV.selectByPhoneNumber(doctorLoginInfo.getPhoneNumber());
    }

    @RequestMapping(value = "/resolveForgotPassword", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody ForgetPwdUser forgetPwddoctor) {
        HttpReqResult httpReqResult = new HttpReqResult();
        _log.info("更新医生信息：" + forgetPwddoctor);
        Doctor doctor = doctorSV.selectByPhoneNumberAndEmail(forgetPwddoctor.getPhoneNumber(), forgetPwddoctor.getEmail());
        if(doctor != null) {
            doctor.setPassword(SecurityUtil.getSHA256Str(forgetPwddoctor.getPassword()));
            doctorSV.updateByPrimaryKey(doctor);
            httpReqResult.setResult(HttpReqResult.SUCCESS);
        }else{
            httpReqResult.setResult(HttpReqResult.FAIL);
        }
        return httpReqResult;
    }

    @RequestMapping(value = "/getValidateCode", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult sendValidateCode(@RequestBody ForgetPwdUser forgetPwddoctor) {
        String validateCode = AppUtil.getRandomValidateCode(6);
        boolean sendResult = emailUtil.sendEmail(AppConstants.EMAIL_TEXT_PREFIX + validateCode + AppConstants.EMAIL_TEXT_SUBFIX, forgetPwddoctor.getEmail(), AppConstants.EMAIL_SUBJECT);
        HttpReqResult httpReqResult = new HttpReqResult();
        if(sendResult) {
            httpReqResult.setResult(HttpReqResult.SUCCESS);
            httpReqResult.setData(validateCode);
        }else{
            httpReqResult.setResult(HttpReqResult.FAIL);
        }
        return httpReqResult;
    }

    @RequestMapping(value = "/getDoctorInfoInList", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public List<UIListItem> getDoctorInfoInList(@RequestBody UserLoginInfo doctorLoginInfo) {
        Doctor doctor = doctorSV.selectByIdCard(doctorLoginInfo.getIdCard());
        List<UIListItem> uiListItems = new ArrayList<>();
        if(doctor.getId() > 0) {
            uiListItems.add(new UIListItem("姓名",doctor.getName(),"0"));
            uiListItems.add(new UIListItem("性别",doctor.getSex(),"1"));
            uiListItems.add(new UIListItem("年龄",String.valueOf(doctor.getAge()),"2"));
            uiListItems.add(new UIListItem("等级",doctor.getLevel(),"3"));
            uiListItems.add(new UIListItem("身份证号", doctor.getIdcard(),"4"));
            uiListItems.add(new UIListItem("就职医院", doctor.getHospitalCode(),"5"));
            uiListItems.add(new UIListItem("就职科室", doctor.getDepartmentCode(),"6"));
            uiListItems.add(new UIListItem("住址",doctor.getAddress(),"7"));
            uiListItems.add(new UIListItem("手机号码",doctor.getPhoneNumber(),"8"));
            uiListItems.add(new UIListItem("从医经历",doctor.getExprience(),"9"));
            uiListItems.add(new UIListItem("邮箱",doctor.getEmail(),"10"));
        }
        return uiListItems;
    }

    @RequestMapping(value = "/selectByIdCard", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public Doctor selectdoctorInfoByIdCard(@RequestBody UserLoginInfo doctorLoginInfo) {
        Doctor doctor = doctorSV.selectByIdCard(doctorLoginInfo.getIdCard());
        return doctor;
    }

    @RequestMapping(value = "/updateDoctorByColumn", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult updatedoctorByColumn(@RequestBody UserLoginInfo doctorLoginInfo) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        Doctor doctor = doctorSV.selectByIdCard(doctorLoginInfo.getIdCard());
        _log.info("接收到的登录信息:" + doctorLoginInfo);
        if(doctorLoginInfo.getKey().equals("7")) {
            doctor.setAddress(doctorLoginInfo.getValue());
        }
        if(doctorLoginInfo.getKey().equals("8")) {
            doctor.setPhoneNumber(doctorLoginInfo.getValue());
        }
        if(doctorLoginInfo.getKey().equals("9")) {
            doctor.setExprience(doctorLoginInfo.getValue());
        }
        if(doctorLoginInfo.getKey().equals("10")) {
            doctor.setEmail(doctorLoginInfo.getValue());
        }
        if(doctorLoginInfo.getKey().equals("-1")) {
            doctor.setPassword(SecurityUtil.getSHA256Str(doctorLoginInfo.getValue()));
        }
        doctorSV.updateByPrimaryKey(doctor);
        return reqResult;
    }

    @RequestMapping(value = "/validatePassword", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult validatePassword(@RequestBody UserLoginInfo doctorLoginInfo) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.FAIL);
        Doctor doctor = doctorSV.selectByIdCard(doctorLoginInfo.getIdCard());
        _log.info("接收到的登录信息:" + doctorLoginInfo);
        if(StringUtils.isNotBlank(doctorLoginInfo.getPassword())) {
            if(SecurityUtil.getSHA256Str(doctorLoginInfo.getPassword()).equals(doctor.getPassword())) {
                reqResult.setResult(HttpReqResult.SUCCESS);
            }
        }
        return reqResult;
    }

    @RequestMapping(value = "/selectAll", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public List<Doctor> selectAll() throws Exception {
        _log.info("查询所有用户");
        List<Doctor> doctors = doctorSV.selectAll();
        if(!doctors.isEmpty()) {
            for(Doctor doctor : doctors) {
                Hospital hospital = hospitalSV.selectByCode(doctor.getHospitalCode());
                if(null != hospital) {
                    doctor.setHospitalname(hospital.getName());
                }
                Department department = departmentSV.selectByCode(doctor.getDepartmentCode());
                if(null != department) {
                    doctor.setDepartmentname(department.getName());
                }
                _log.error("doctor信息:" + doctor);
            }
        }
        return doctors;
    }

    @RequestMapping(value = "/deleteByIdcard", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult deleteByIdcard(@RequestBody Doctor doctor) throws Exception {
        return new HttpReqResult(doctorSV.deleteByPrimaryKey(doctor.getId())==1?HttpReqResult.SUCCESS:HttpReqResult.FAIL);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody Doctor doctor){
        return new HttpReqResult(doctorSV.updateByPrimaryKey(doctor)==1?HttpReqResult.SUCCESS:HttpReqResult.FAIL);
    }
}
