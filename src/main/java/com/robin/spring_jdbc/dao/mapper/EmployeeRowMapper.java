package com.robin.spring_jdbc.dao.mapper;

import com.robin.spring_jdbc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Autowired
    private EmployeeResultSetExtractor extractor;

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return extractor.extractData(rs);
    }
}
