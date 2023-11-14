package com.luv2code.cruddemo1.dao;

import com.luv2code.cruddemo1.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
