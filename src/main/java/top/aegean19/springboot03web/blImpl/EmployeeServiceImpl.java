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

    private static Integer iniId=1006;

    @Override
    public void save(Employee employee) {
        if (employee.getId()==null) employee.setId(iniId++);
        employeeMapper.save(employee);
    }

    @Override
    public List<Employee> getAll() {
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
