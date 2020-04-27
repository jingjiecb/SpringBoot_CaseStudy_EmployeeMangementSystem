package top.aegean19.springboot03web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * 员工简单对象
 */
@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0代表女，1代表男

    private Integer departmentId;
    private Date birthday;

    public Employee(Integer id, String lastName, String email, Integer gender, int departmentId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.departmentId = departmentId;
        //默认日期
        this.birthday = new Date();
    }
}
