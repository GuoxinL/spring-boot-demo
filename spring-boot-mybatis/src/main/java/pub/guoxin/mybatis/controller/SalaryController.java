package pub.guoxin.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.guoxin.mybatis.model.SalaryMessage;
import pub.guoxin.mybatis.service.SalaryService;

import java.util.Objects;

/**
 * Created by guoxin on 17-3-29.
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(Integer a, Integer b, Double money) {
        if (Objects.isNull(a) && a <= 0) {
            return "用户id不合法";
        }

        if (Objects.isNull(b) && b <= 0) {
            return "用户id不合法";
        }
        if (Objects.isNull(money) && money <= 0) {
            return "用户id不合法";
        }

        SalaryMessage transfer = null;
        try {
            transfer = salaryService.transfer(a, b, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transfer.toString();
    }

}
