package com.luv2code.cruddemo1.dao;

import com.luv2code.cruddemo1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
