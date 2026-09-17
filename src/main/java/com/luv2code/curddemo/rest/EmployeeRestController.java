package com.luv2code.curddemo.rest;

import com.luv2code.curddemo.dao.EmployeeDAO;
import com.luv2code.curddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // Quick and dirty: inject employee dao (use contractor injection)
    public EmployeeRestController(EmployeeDAO theEmployee){
        employeeDAO = theEmployee;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
