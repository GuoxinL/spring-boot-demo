package pub.guoxin.undertow.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Create by guoxin on 2018/4/23
 */
@RestController
public class SampleController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/async")
    public Callable<String> helloWorldAsync() {
        return () -> "async: Hello World";
    }

}