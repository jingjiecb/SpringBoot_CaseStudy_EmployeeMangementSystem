package top.aegean19.springboot03web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.aegean19.springboot03web.pojo.Department;
import top.aegean19.springboot03web.pojo.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees=null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    //员工
    static {
        employees=new HashMap<>();

        employees.put(1001,new Employee(1001,"AA","123@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","234@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","345@qq.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","456@qq.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","567@qq.com",1,new Department(105,"后勤部")));
    }

    //增加员工
    private static Integer iniId=1006;
    public void add(Employee employee){
        if (employee.getId()==null) employee.setId(iniId++);

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

//    public void update(Employee employee){
//
//    }
}
