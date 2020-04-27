package top.aegean19.springboot03web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.aegean19.springboot03web.bl.DepartmentService;
import top.aegean19.springboot03web.bl.EmployeeService;
import top.aegean19.springboot03web.pojo.Department;
import top.aegean19.springboot03web.pojo.Employee;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    //员工列表页面
    @RequestMapping("/emps")
    public String list(Model model){
//        System.out.println("info===> 接受到请求");
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("emps",employees);
        model.addAttribute("dpt",departmentService);
        return "emp/list";
    }

    //跳转到添加员工页面
    @GetMapping("/addEmp")
    public String toAddpage(Model model){
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("dpts",departments);
        return "emp/add";
    }

    //提交添加的新员工，返回员工列表
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        //System.out.println("addEmployee==> "+employee);
        employeeService.save(employee);
        return "redirect:/emps";
    }

    //跳转到修改员工信息页面
    @GetMapping("/update")
    public String toUpdateEmp(@RequestParam("id") Integer eid, Model model){
        List<Department> departments = departmentService.getDepartments();
        Employee employee = employeeService.getEmployeeById(eid);
        model.addAttribute("dpts",departments);
        model.addAttribute("employee",employee);
        return "emp/update";
    }

    //接受修改员工信息页面传来的表单，更新员工并跳转到员工列表页面
    @PostMapping("/update")
    public String updateEmp(Employee employee){
//        System.out.println("updata=====>"+employee.toString());
        employeeService.update(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delete")
    public String deleteEmp(@RequestParam("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
