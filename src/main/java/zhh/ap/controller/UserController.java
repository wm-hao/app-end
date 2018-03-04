package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;
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

    @RequestMapping(path = {"/validateLogin"})
    public HttpReqResult validateLogin(@RequestParam String phoneNumber, @RequestParam String password) {
        HttpReqResult HttpReqResult = new HttpReqResult();
        HttpReqResult.setResult(userSV.validate(phoneNumber, password) ? "true" : "false");
        return HttpReqResult;
    }

    @RequestMapping(path = {"/validateLogin2"})
    public HttpReqResult validateLogin2(UserLoginInfo userLoginInfo) {
        HttpReqResult HttpReqResult = new HttpReqResult();
        System.out.println(userLoginInfo);
        HttpReqResult.setResult(userSV.validate(userLoginInfo.getPhoneNumber(), userLoginInfo.getPassword()) ? "true" : "false");
        return HttpReqResult;
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST,RequestMethod.OPTIONS})
    public HttpReqResult addUser(@ModelAttribute User user) {
        _log.info("req post data:" + user);
        userSV.insert(user);
        return new HttpReqResult(HttpReqResult.SUCCESS);
    }
}
