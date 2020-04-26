package top.aegean19.springboot03web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.aegean19.springboot03web.bl.DepartmentService;
import top.aegean19.springboot03web.dao.DepartmentDao;
import top.aegean19.springboot03web.dao.EmployeeDao;
import top.aegean19.springboot03web.pojo.Department;
import top.aegean19.springboot03web.pojo.Employee;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/addEmp")
    public String toAddpage(Model model){
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("dpts",departments);
        return "emp/add";
    }

    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        //System.out.println("addEmployee==> "+employee);
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @GetMapping("/update")
    public String toUpdateEmp(@RequestParam("id") Integer eid, Model model){
        Collection<Department> departments=departmentDao.getDepartments();
        Employee employee = employeeDao.getEmployeeById(eid);
        model.addAttribute("dpts",departments);
        model.addAttribute("employee",employee);
        return "emp/update";
    }

    @PostMapping("/update")
    public String updateEmp(Employee employee){
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
