package top.aegean19.springboot03web.bl;

import top.aegean19.springboot03web.pojo.Department;

import java.util.List;

public interface DepartmentService {

    //获得所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public Department getDepartmentById(Integer id);
}
