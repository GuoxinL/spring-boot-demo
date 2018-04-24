package pub.guoxin.demo.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/tologin")
    public String toLogin(Model model){
        model.addAttribute("error", false);
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password){
        String viewName = null;
        ModelAndView modelAndView = new ModelAndView(viewName);
        if ("admin".equals(username) && "admin".equals(password)){
            modelAndView.setViewName("index");
            modelAndView.addObject("username","admin");
            modelAndView.addObject("message","Welcome my page");
            modelAndView.addObject("error",false);
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("error",true);

        }
        return modelAndView;
    }
}
