package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;
import zhh.ap.util.security.SecurityUtil;
import zhh.ap.valuebean.AppConstants;
import zhh.ap.valuebean.HttpReqResult;

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

    @RequestMapping(path = {"/validateLogin"})
    public HttpReqResult validateLogin(@RequestParam String phoneNumber, @RequestParam String password) {
        _log.info("验证用户信息，手机号：" + phoneNumber + ";密码：" + password);
        HttpReqResult HttpReqResult = new HttpReqResult();
        HttpReqResult.setResult(userSV.validate(phoneNumber, password) ? zhh.ap.valuebean.HttpReqResult.SUCCESS : zhh.ap.valuebean.HttpReqResult.FAIL);
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

    @RequestMapping("/selectByPhoneNumber")
    public User selectByPhoneNumber(@RequestParam String phoneNumber) {
        _log.info("根据手机号查询用户:" + phoneNumber);
        return userSV.selectByPhoneNumber(phoneNumber);
    }

}
