package zhh.ap.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.Admin;
import zhh.ap.service.IAppAdminSV;
import zhh.ap.util.AppUtil;
import zhh.ap.util.email.EmailUtil;
import zhh.ap.util.security.SecurityUtil;
import zhh.ap.valuebean.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private static transient Log _log = LogFactory.getLog(AdminController.class);
    @Resource(name = "appAdminSV")
    private IAppAdminSV adminSV;
    @Resource(name = "emailUtil")
    private EmailUtil emailUtil;

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult add(@RequestBody Admin admin) {
        HttpReqResult httpReqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        try {
            admin.setPassword(SecurityUtil.getSHA256Str(admin.getPassword()));
            admin.setSex(admin.getSex().equals(String.valueOf(AppConstants.SEX_MAN_FLAG)) ? AppConstants.SEX_MAN_STR : AppConstants.SEX_WOMAN_STR);
            admin.setAdminCode(admin.getPhoneNumber());
            admin.setAuthority(AppConstants.ADMIN_AUTHORITY);
            adminSV.insert(admin);
        } catch (Exception e) {
            _log.error(e);
            httpReqResult.setResult(HttpReqResult.FAIL);
        }
        return httpReqResult;
    }

    @RequestMapping(path = {"/validateLogin"}, method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult validateLogin(@RequestBody UserLoginInfo adminLoginInfo) {
        _log.info("验证管理员信息:" + adminLoginInfo);
        HttpReqResult HttpReqResult = new HttpReqResult();
        boolean success = adminSV.validate(adminLoginInfo.getPhoneNumber(), adminLoginInfo.getPassword());
        if(success) {
            HttpReqResult.setResult(zhh.ap.valuebean.HttpReqResult.SUCCESS);
        }else  {
            HttpReqResult.setResult(zhh.ap.valuebean.HttpReqResult.FAIL);
            HttpReqResult.setData("您输入的用户名密码不正确！");
        }
        return HttpReqResult;
    }

    @RequestMapping(value = "/selectByPhoneNumber", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public Admin selectByPhoneNumber(@RequestBody UserLoginInfo adminLoginInfo) {
        _log.info("根据手机号管理员:" + adminLoginInfo.getPhoneNumber());
        return adminSV.selectByPhoneNumber(adminLoginInfo.getPhoneNumber());
    }

    @RequestMapping(value = "/resolveForgotPassword", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody ForgetPwdUser forgetPwdUser) {
        HttpReqResult httpReqResult = new HttpReqResult();
        _log.info("更新医生密码：" + forgetPwdUser);
        Admin admin = adminSV.selectByPhoneNumberAndEmail(forgetPwdUser.getPhoneNumber(), forgetPwdUser.getEmail());
        if(admin == null) {
            httpReqResult.setResult(HttpReqResult.FAIL);
            httpReqResult.setData("未查询到管理员信息");
        }else{
            admin.setPassword(SecurityUtil.getSHA256Str(admin.getPassword()));
            adminSV.updateByPrimaryKey(admin);
            httpReqResult.setResult(HttpReqResult.SUCCESS);
        }
        return httpReqResult;
    }

    @RequestMapping(value = "/getValidateCode", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult sendValidateCode(@RequestBody ForgetPwdUser admin) {
        HttpReqResult httpReqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        String validateCode = AppUtil.getRandomValidateCode(6);
        boolean sendResult = emailUtil.sendEmail(AppConstants.EMAIL_TEXT_PREFIX + validateCode + AppConstants.EMAIL_TEXT_SUBFIX, admin.getEmail(), AppConstants.EMAIL_SUBJECT);
        if(sendResult) {
            httpReqResult.setData(validateCode);
        }else{
            httpReqResult.setResult(HttpReqResult.FAIL);
        }
        return httpReqResult;
    }

    @RequestMapping(value = "/getAdminInfoInList", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public List<UIListItem> getAdminInfoInList(@RequestBody UserLoginInfo adminLoginInfo) {
        Admin admin = adminSV.selectByIdCard(adminLoginInfo.getIdCard());
        List<UIListItem> uiListItems = new ArrayList<>();
        if(admin.getId() > 0) {
            uiListItems.add(new UIListItem("姓名",admin.getName(),"0"));
            uiListItems.add(new UIListItem("性别",admin.getSex(),"1"));
            uiListItems.add(new UIListItem("年龄",String.valueOf(admin.getAge()),"2"));
            uiListItems.add(new UIListItem("身份证号", admin.getIdcard(),"3"));
            uiListItems.add(new UIListItem("权限等级", admin.getAuthority(),"4"));
            uiListItems.add(new UIListItem("手机号码", admin.getPhoneNumber(),"5"));
            uiListItems.add(new UIListItem("邮箱",admin.getEmail(),"6"));
        }
        return uiListItems;
    }

    @RequestMapping(value = "/selectByIdCard", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public Admin selectAdminInfoByIdCard(@RequestBody UserLoginInfo adminLoginInfo) {
        return adminSV.selectByIdCard(adminLoginInfo.getIdCard());
    }

    @RequestMapping(value = "/updateAdminByColumn", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult updateByColumn(@RequestBody UserLoginInfo adminLoginInfo) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        Admin admin = adminSV.selectByIdCard(adminLoginInfo.getIdCard());
        _log.info("接收到的登录信息:" + adminLoginInfo);
        if(adminLoginInfo.getKey().equals("5")) {
            admin.setPhoneNumber(adminLoginInfo.getValue());
        }
        if(adminLoginInfo.getKey().equals("6")) {
            admin.setEmail(adminLoginInfo.getValue());
        }
        if(adminLoginInfo.getKey().equals("-1")) {
            admin.setPassword(SecurityUtil.getSHA256Str(adminLoginInfo.getPassword()));
        }
        adminSV.updateByPrimaryKey(admin);
        return reqResult;
    }

    @RequestMapping(value = "/validatePassword", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult validatePassword(@RequestBody UserLoginInfo adminLoginInfo) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.FAIL);
        Admin admin = adminSV.selectByIdCard(adminLoginInfo.getIdCard());
        _log.info("接收到的登录信息:" + adminLoginInfo);
        if(StringUtils.isNotBlank(adminLoginInfo.getPassword())) {
            if(SecurityUtil.getSHA256Str(adminLoginInfo.getPassword()).equals(admin.getPassword())) {
                reqResult.setResult(HttpReqResult.SUCCESS);
            }
        }
        return reqResult;
    }
}
