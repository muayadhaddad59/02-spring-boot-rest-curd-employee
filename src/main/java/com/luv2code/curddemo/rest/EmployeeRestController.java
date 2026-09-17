package com.luv2code.curddemo.rest;

import com.luv2code.curddemo.entity.Employee;
import com.luv2code.curddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Quick and dirty: inject employee dao (use contractor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // Add mapping for GET /employees/{employeeId}
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // Add mapping for POST / employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON .. set id to 0
        // this is to force a save of new item ... instead of update

        // if your employee class has int id:: then you can use theEmployee(0)
        // However, if you have alternate coding in employee class: private Integer id;  ::  then you must use theEmployee.setId(null);

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return  dbEmployee;
    }
}
