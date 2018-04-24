package pub.guoxin.aop;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.guoxin.aop.anno.QueryCache;

/**
 * Created by guoxin on 17-11-23.
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @QueryCache(namespace = "xxx")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(String haha){
        System.out.println(haha);
        return haha;
    }
}
