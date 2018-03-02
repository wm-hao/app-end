package zhh.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/elementUI")
    public String elementUI() {
        return "elementUI";
    }

    @RequestMapping("/b4")
    public String b4() {
        return "b4";
    }
}
