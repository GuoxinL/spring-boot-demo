package pub.guoxin.jsp.controller;

/**
 * Created by guoxin on 17-8-27.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * 测试
 *
 * @version v.0.1
 * @authorAngel(QQ:412887952)
 */

@Controller
public class HelloController {

    // 从 application.properties 中读取配置，如取不到默认值为HelloShanhy
    @Value("${application.hello:Hello Angel}")
    private String hello;

    @RequestMapping("/hello")
    public ModelAndView hello(Map<String, Object> map) {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("hello", hello);
        System.out.println(hello);
        return mav;
    }

}