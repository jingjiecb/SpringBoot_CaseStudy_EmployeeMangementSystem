package top.aegean19.springboot03web.blImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aegean19.springboot03web.bl.DepartmentService;
import top.aegean19.springboot03web.mapper.DepartmentMapper;
import top.aegean19.springboot03web.pojo.Department;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getAllDpt();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDptById(id);
    }
}
