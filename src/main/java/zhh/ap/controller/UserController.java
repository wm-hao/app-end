package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;
import zhh.ap.util.AppUtil;
import zhh.ap.util.email.EmailUtil;
import zhh.ap.util.security.SecurityUtil;
import zhh.ap.valuebean.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    private static transient Log _log = LogFactory.getLog(UserController.class);
    @Resource(name = "appUserSV")
    private IAppUserSV userSV;
    @Resource(name = "emailUtil")
    private EmailUtil emailUtil;

    @RequestMapping("/userInfo")
    public User getUserInfo(@RequestParam String id) {
        return userSV.selectByPrimaryKey(Integer.valueOf(id));
    }

    @RequestMapping(path = {"/validateLogin"}, method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult validateLogin(@RequestBody UserLoginInfo userLoginInfo) {
        _log.info("验证用户信息:" + userLoginInfo);
        HttpReqResult HttpReqResult = new HttpReqResult();
        HttpReqResult.setResult(userSV.validate(userLoginInfo.getPhoneNumber(), userLoginInfo.getPassword()) ? zhh.ap.valuebean.HttpReqResult.SUCCESS : zhh.ap.valuebean.HttpReqResult.FAIL);
        return HttpReqResult;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult addUser(@RequestBody User user) {
        _log.info("接收到的注册用户信息:" + user);
        user.setPassword(SecurityUtil.getSHA256Str(user.getPassword()));
        user.setSex(user.getSex().equals(String.valueOf(AppConstants.SEX_MAN_FLAG)) ? AppConstants.SEX_MAN_STR : AppConstants.SEX_WOMAN_STR);
        user.setUserCode(user.getPhoneNumber());
        userSV.insert(user);
        return new HttpReqResult(HttpReqResult.SUCCESS);
    }

    @RequestMapping(value = "/selectByPhoneNumber", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public User selectByPhoneNumber(@RequestBody UserLoginInfo userLoginInfo) {
        _log.info("根据手机号查询用户:" + userLoginInfo.getPhoneNumber());
        return userSV.selectByPhoneNumber(userLoginInfo.getPhoneNumber());
    }

    @RequestMapping(value = "/resolveForgotPassword", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult updateUser(@RequestBody ForgetPwdUser forgetPwdUser) {
        HttpReqResult httpReqResult = new HttpReqResult();
        _log.info("更新用户信息：" + forgetPwdUser);
        User user = userSV.selectByPhoneNumberAndEmail(forgetPwdUser.getPhoneNumber(), forgetPwdUser.getEmail());
        if(user == null) {
            httpReqResult.setResult(HttpReqResult.FAIL);
        }else{
            user.setPassword(SecurityUtil.getSHA256Str(forgetPwdUser.getPassword()));
            userSV.updateByPrimaryKey(user);
            httpReqResult.setResult(HttpReqResult.SUCCESS);
        }
        return httpReqResult;
    }

    @RequestMapping(value = "/getValidateCode", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult sendValidateCode(@RequestBody ForgetPwdUser forgetPwdUser) {
        HttpReqResult httpReqResult = new HttpReqResult();
        String validateCode = AppUtil.getRandomValidateCode(6);
        boolean sendResult = emailUtil.sendEmail(AppConstants.EMAIL_TEXT_PREFIX + validateCode + AppConstants.EMAIL_TEXT_SUBFIX, forgetPwdUser.getEmail(), AppConstants.EMAIL_SUBJECT);
        if(sendResult) {
            httpReqResult.setResult(HttpReqResult.SUCCESS);
            httpReqResult.setData(validateCode);
        }else{
            httpReqResult.setResult(HttpReqResult.FAIL);
        }
        return httpReqResult;
    }

    @RequestMapping(value = "/getUserInfoInList", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public  List<UIListItem> getUserInfoInList(@RequestBody UserLoginInfo userLoginInfo) {
        User user = userSV.selectByPhoneNumber(userLoginInfo.getPhoneNumber());
        List<UIListItem> uiListItems = new ArrayList<>();
        if(user.getId() > 0) {
            uiListItems.add(new UIListItem("姓名",user.getName()));
            uiListItems.add(new UIListItem("性别",user.getSex()));
            uiListItems.add(new UIListItem("邮箱",user.getEmail()));
            uiListItems.add(new UIListItem("住址",user.getAddress()));
            uiListItems.add(new UIListItem("年龄",String.valueOf(user.getAge())));
            uiListItems.add(new UIListItem("身份证号", user.getIdcard()));
            uiListItems.add(new UIListItem("手机号码",user.getPhoneNumber()));
            uiListItems.add(new UIListItem("QQ",user.getQq()));
        }
        return uiListItems;
    }
}
