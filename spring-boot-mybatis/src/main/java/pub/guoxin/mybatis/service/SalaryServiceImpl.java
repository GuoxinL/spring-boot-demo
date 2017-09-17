package pub.guoxin.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pub.guoxin.mybatis.mapper.SalaryMapper;
import pub.guoxin.mybatis.model.Salary;
import pub.guoxin.mybatis.model.SalaryMessage;

/**
 * Created by guoxin on 17-9-17.
 */
@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public SalaryMessage transfer(Integer a, Integer b, Double money) throws Exception {
        Salary userA = salaryMapper.findById(a);
        Salary userB = salaryMapper.findById(b);
        Double salaryA = userA.getSalary();
        if (!(salaryA - money >= 0)) {
            return new SalaryMessage("金额不足", false);
        }
        userA.setSalary(salaryA - money);
        int modifyA = salaryMapper.modifySalaryById(userA);
        System.out.println(modifyA);
        userB.setSalary(userB.getSalary() + money);

        int modifyB = salaryMapper.modifySalaryById(userB);
        System.out.println(modifyB);
//        if (0 == 0)
//            throw new Exception();
        return new SalaryMessage("modifyA:" + modifyA + ",modifyB:" + modifyB, true);
    }
}
