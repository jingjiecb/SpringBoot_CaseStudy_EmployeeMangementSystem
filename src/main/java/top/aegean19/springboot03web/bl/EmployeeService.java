package top.aegean19.springboot03web.bl;

import top.aegean19.springboot03web.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    public void save(Employee employee);

    //查询全部员工
    public List<Employee> getAll();

    //通过id查询员工
    public Employee getEmployeeById(Integer id);

    //删除员工
    public void delete(Integer id);

}
