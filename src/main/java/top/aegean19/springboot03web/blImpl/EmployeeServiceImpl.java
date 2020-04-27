package top.aegean19.springboot03web.blImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aegean19.springboot03web.bl.EmployeeService;
import top.aegean19.springboot03web.mapper.DepartmentMapper;
import top.aegean19.springboot03web.mapper.EmployeeMapper;
import top.aegean19.springboot03web.pojo.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    //自动员工ID分配，初始员工编号1001
    private static Integer iniId=1001;

    @Override
    public void save(Employee employee) {
        while (employeeMapper.getEmpById(iniId)!=null) iniId++;
        if (employee.getId()==null) employee.setId(iniId++);
        employeeMapper.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public List<Employee> getAll() {
//        System.out.println("info===> 业务逻辑层开始处理请求");
        return employeeMapper.getAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void delete(Integer id) {
        employeeMapper.delete(id);
    }
}
