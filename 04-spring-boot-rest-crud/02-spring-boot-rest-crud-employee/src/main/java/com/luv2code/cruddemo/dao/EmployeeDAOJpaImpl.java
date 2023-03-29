package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define fields for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    @Override
    public List< Employee > findAll() {

        // create a query
        TypedQuery< Employee > theQuery = entityManager.createQuery( "from Employee", Employee.class );

        // execute query and get result list
        List< Employee > employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int id) {

        // get employees
        Employee employee = entityManager.find( Employee.class, id );

        // return employees
        return employee;
    }

    @Override
    public Employee save( Employee employee ) {

        // save employee
        Employee dbEmployee = entityManager.merge( employee );

        // return employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        // find employee by id
        Employee employee = entityManager.find( Employee.class, id );

        // remove employee
        entityManager.remove( employee );
    }
}
