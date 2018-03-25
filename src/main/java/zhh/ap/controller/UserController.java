package zhh.ap.controller;

import org.apache.commons.lang3.StringUtils;
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
        boolean success = userSV.validate(userLoginInfo.getPhoneNumber(), userLoginInfo.getPassword());
        if(success) {
            HttpReqResult.setResult(zhh.ap.valuebean.HttpReqResult.SUCCESS);
        }else  {
            HttpReqResult.setResult(zhh.ap.valuebean.HttpReqResult.FAIL);
            HttpReqResult.setData("您输入的用户名密码不正确！");
        }
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
        User user = userSV.selectUserInfoByIdCard(userLoginInfo.getIdCard());
        List<UIListItem> uiListItems = new ArrayList<>();
        if(user.getId() > 0) {
            uiListItems.add(new UIListItem("姓名",user.getName(),"0"));
            uiListItems.add(new UIListItem("性别",user.getSex(),"1"));
            uiListItems.add(new UIListItem("年龄",String.valueOf(user.getAge()),"2"));
            uiListItems.add(new UIListItem("身份证号", user.getIdcard(),"3"));
            uiListItems.add(new UIListItem("住址",user.getAddress(),"4"));
            uiListItems.add(new UIListItem("手机号码",user.getPhoneNumber(),"5"));
            uiListItems.add(new UIListItem("QQ",user.getQq(),"6"));
            uiListItems.add(new UIListItem("邮箱",user.getEmail(),"7"));
        }
        return uiListItems;
    }

    @RequestMapping(value = "/selectUserInfoByIdCard", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public User selectUserInfoByIdCard(@RequestBody UserLoginInfo userLoginInfo) {
        User user = userSV.selectUserInfoByIdCard(userLoginInfo.getIdCard());
        return user;
    }

    @RequestMapping(value = "/updateUserByColumn", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult updateUserByColumn(@RequestBody UserLoginInfo userLoginInfo) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        User user = userSV.selectUserInfoByIdCard(userLoginInfo.getIdCard());
        _log.info("接收到的LoginUserInfo:" + userLoginInfo);
        if(userLoginInfo.getKey().equals("4")) {
            user.setAddress(userLoginInfo.getValue());
        }
        if(userLoginInfo.getKey().equals("5")) {
            user.setPhoneNumber(userLoginInfo.getValue());
        }
        if(userLoginInfo.getKey().equals("6")) {
            user.setQq(userLoginInfo.getValue());
        }
        if(userLoginInfo.getKey().equals("7")) {
            user.setEmail(userLoginInfo.getValue());
        }
        if(userLoginInfo.getKey().equals("-1")) {
            user.setPassword(SecurityUtil.getSHA256Str(userLoginInfo.getPassword()));
        }
        userSV.updateByPrimaryKey(user);
        return reqResult;
    }

    @RequestMapping(value = "/validatePassword", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult validatePassword(@RequestBody UserLoginInfo userLoginInfo) {
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.FAIL);
        User user = userSV.selectUserInfoByIdCard(userLoginInfo.getIdCard());
        _log.info("接收到的LoginUserInfo:" + userLoginInfo);
        if(StringUtils.isNotBlank(userLoginInfo.getPassword())) {
            if(SecurityUtil.getSHA256Str(userLoginInfo.getPassword()).equals(user.getPassword())) {
                reqResult.setResult(HttpReqResult.SUCCESS);
            }
        }
        return reqResult;
    }

    @RequestMapping(value = "/selectAll", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public List<User> selectAll() throws Exception {
        _log.info("查询所有用户");
        List<User> users = userSV.selectAll();
        return users;
    }

    @RequestMapping(value = "/deleteByIdcard", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult deleteByIdcard(@RequestBody User user) throws Exception {
        _log.info("删除用户根据身份证");
        return new HttpReqResult(userSV.deleteByPrimaryKey(user.getId())==1?HttpReqResult.SUCCESS:HttpReqResult.FAIL);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody User user){
        _log.info("更新用户根据身份证");
        return new HttpReqResult(userSV.updateByPrimaryKey(user)==1?HttpReqResult.SUCCESS:HttpReqResult.FAIL);
    }

    @RequestMapping(value = "/updateAll", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public HttpReqResult update(@RequestBody List<User> users){
        _log.info("全量更新");
        for(User user : users) {
            userSV.updateByPrimaryKey(user);
        }
        return new HttpReqResult(HttpReqResult.SUCCESS);
    }


}
