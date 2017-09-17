package pub.guoxin.mybatis.service;

import pub.guoxin.mybatis.model.SalaryMessage;

/**
 * Created by guoxin on 17-9-17.
 */
public interface SalaryService {

    public SalaryMessage transfer(Integer a, Integer b, Double money) throws Exception;
}
