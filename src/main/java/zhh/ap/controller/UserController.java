package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;
import zhh.ap.util.security.SecurityUtil;
import zhh.ap.valuebean.AppConstants;
import zhh.ap.valuebean.HttpReqResult;
import zhh.ap.valuebean.UserLoginInfo;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class UserController {

    private static transient Log _log = LogFactory.getLog(UserController.class);
    @Resource(name = "appUserSV")
    private IAppUserSV userSV;

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
        userSV.insert(user);
        return new HttpReqResult(HttpReqResult.SUCCESS);
    }

    @RequestMapping(value = "/selectByPhoneNumber", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public User selectByPhoneNumber(@RequestBody UserLoginInfo userLoginInfo) {
        _log.info("根据手机号查询用户:" + userLoginInfo.getPhoneNumber());
        return userSV.selectByPhoneNumber(userLoginInfo.getPhoneNumber());
    }

}
