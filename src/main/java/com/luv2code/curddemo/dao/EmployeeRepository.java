package com.luv2code.curddemo.dao;

import com.luv2code.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it ... no need to write any code
}
