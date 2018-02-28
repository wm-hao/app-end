package zhh.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.User;
import zhh.ap.service.IAppUserSV;

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
    public String validateLogin(@RequestParam String phoneNumber, @RequestParam String password) {
        return userSV.validate(phoneNumber, password) ? "true" : "false";
    }

}
