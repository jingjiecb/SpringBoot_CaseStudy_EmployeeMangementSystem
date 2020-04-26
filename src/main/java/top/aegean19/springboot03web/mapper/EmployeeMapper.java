package top.aegean19.springboot03web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aegean19.springboot03web.pojo.Employee;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    int save(Employee employee);

    int update(Employee employee);

    List<Employee> getAll();

    Employee getEmpById(Integer id);

    int delete(Integer id);
}
