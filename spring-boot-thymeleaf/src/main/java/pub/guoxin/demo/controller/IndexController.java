package pub.guoxin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by guoxin on 17-4-14.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "redirect:index";
    }

    @RequestMapping("index")
    public String index(Map<String, String> model) {
        model.put("message", "Hello World");
        return "index";
    }
    @RequestMapping("/login")
    public String Login(){
        return "login";
    }
}
