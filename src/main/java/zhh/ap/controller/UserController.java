package zhh.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;
import zhh.ap.valuebean.HttpResponse;
import zhh.ap.valuebean.UserLoginInfo;

@RestController
//@CrossOrigin(origins = {"*"},methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Autowired
    private IAppUserSV userSV;

    @RequestMapping("/userInfo")
    public User getUserInfo(@RequestParam String id) {
        return userSV.selectByPrimaryKey(Integer.valueOf(id));
    }

    @RequestMapping(path = {"/validateLogin"})
    public HttpResponse validateLogin(@RequestParam String phoneNumber, @RequestParam String password) {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setResult(userSV.validate(phoneNumber, password) ? "true" : "false");
        return httpResponse;
    }

    @RequestMapping(path = {"/validateLogin2"})
    public HttpResponse validateLogin2(UserLoginInfo userLoginInfo) {
        HttpResponse httpResponse = new HttpResponse();
        System.out.println(userLoginInfo);
        httpResponse.setResult(userSV.validate(userLoginInfo.getPhoneNumber(), userLoginInfo.getPassword()) ? "true" : "false");
        return httpResponse;
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
