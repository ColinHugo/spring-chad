package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api" )
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping( "/employees" )
    public List< Employee > findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping( "/employees/{employeeId}" )
    public Employee getEmployee( @PathVariable int employeeId ) {

        Employee employee = employeeService.findById( employeeId );

        if ( employee == null ) {
            throw new RuntimeException( "Employee id not found - " + employeeId );
        }

        return employee;
    }

    // add mapping for POST /employee - add new employee

    @PostMapping( "/employees" )
    public Employee addEmployee( @RequestBody Employee employee ) {

        // also just in case they pass an id in JSON... set id to 0
        // this is to force a save of new item... instead update

        employee.setId( 0 );

        Employee dbEmployee = employeeService.save( employee );

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping( "/employees" )
    public Employee updateEmployee( @RequestBody Employee employee ) {

        Employee dbEmployee = employeeService.save( employee );

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId}
    @DeleteMapping( "/employees/{employeeId}" )
    public String deleteEmployee( @PathVariable int employeeId ) {

        Employee tempEmployee = employeeService.findById( employeeId );

        // throw exception if null
        if ( tempEmployee == null ) {
            throw new RuntimeException( "Employee id not found - " + employeeId );
        }

        employeeService.deleteById( employeeId );

        return "Deleted employee id - " + employeeId;
    }



}
