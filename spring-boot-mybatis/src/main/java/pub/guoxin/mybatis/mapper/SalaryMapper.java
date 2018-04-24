package pub.guoxin.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import pub.guoxin.mybatis.model.Salary;

@Mapper
public interface SalaryMapper {

    Salary findById(Integer id);

    int modifySalaryById(Salary salary);

}