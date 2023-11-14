package com.luv2code.cruddemo1.dao;

import com.luv2code.cruddemo1.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" , Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;

    }
    @Override
    public Employee findById(int theId){
        Employee theEmployee = entityManager.find(Employee.class , theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee){

        // if the employee id ==0 then merge will save it... else it will update
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }
    @Override
    public void deleteById(int theId){

        Employee theEmployee = entityManager.find(Employee.class , theId);

        entityManager.remove(theEmployee);
    }

}
