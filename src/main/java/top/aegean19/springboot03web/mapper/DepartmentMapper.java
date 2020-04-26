package top.aegean19.springboot03web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aegean19.springboot03web.pojo.Department;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> getAllDpt();

    Department getDptById(int id);

}
