package com.luv2code.curddemo.dao;

import com.luv2code.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
