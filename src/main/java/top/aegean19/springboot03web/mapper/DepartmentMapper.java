package top.aegean19.springboot03web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aegean19.springboot03web.pojo.Department;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    //查找所有部门信息
    List<Department> getAllDpt();

    //根据部门ID查找部门
    Department getDptById(Integer id);
}
