package top.aegean19.springboot03web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aegean19.springboot03web.pojo.Employee;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    //添加新员工
    int save(Employee employee);

    //更新员工
    int update(Employee employee);

    //获得所有员工
    List<Employee> getAll();

    //根据ID查找员工
    Employee getEmpById(Integer id);

    //根据ID删除员工
    int delete(Integer id);
}
