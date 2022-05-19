package com.robin.spring_jdbc.dao;

import com.robin.spring_jdbc.dao.mapper.EmployeeRowMapper;
import com.robin.spring_jdbc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {

    public static final String INSERT_SQL = "INSERT INTO employees (name, age) VALUES ('%s', %d);";

    public static final String SELECT_BY_NAME_SQL = "SELECT * FROM employees WHERE name = '%s';";

    public static final String SELECT_ALL_SQL = "SELECT * FROM employees;";

    public static final String DELETE_BY_ID_SQL = "DELETE FROM employees WHERE id = %d;";

    public static final String DELETE_ALL_SQL = "DELETE FROM employees;";

    @Autowired
    private EmployeeRowMapper employeeRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean create(String name, int age){
        try{
            return jdbcTemplate.update(String.format(INSERT_SQL, name, age)) > 0;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<Employee> selectByName(String name){
        try{
            return jdbcTemplate.query(String.format(SELECT_BY_NAME_SQL, name), employeeRowMapper);
        }catch (Exception e){
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public List<Employee> selectAll(){
        try{
            return jdbcTemplate.query(SELECT_ALL_SQL, employeeRowMapper);
        }catch (Exception e){
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public boolean deleteById(int id){
        try{
            return jdbcTemplate.update(String.format(DELETE_BY_ID_SQL, id)) > 0;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteAll(){
        try{
            return jdbcTemplate.update(DELETE_ALL_SQL) > 0;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
