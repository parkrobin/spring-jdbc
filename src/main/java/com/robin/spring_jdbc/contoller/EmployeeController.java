package com.robin.spring_jdbc.contoller;

import com.robin.spring_jdbc.dao.EmployeeDao;
import com.robin.spring_jdbc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("")
    public Boolean createEmployee(String name, int age){
        return employeeDao.create(name, age);
    }

    @GetMapping("")
    public List<Employee> getEmployeesByName(String name){
        return employeeDao.selectByName(name);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesAll(){
        return employeeDao.selectAll();
    }

    @DeleteMapping("")
    public Boolean deleteEmployeesById(int id){
        return employeeDao.deleteById(id);
    }

    @DeleteMapping("/all")
    public Boolean deleteEmployeesAll(){
        return employeeDao.deleteAll();
    }
}
