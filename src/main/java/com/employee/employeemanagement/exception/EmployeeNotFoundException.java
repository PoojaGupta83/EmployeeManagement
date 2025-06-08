package com.employee.employeemanagement.exception;

import java.io.Serial;
//custom exception for handling cases when an employee is not found
public class EmployeeNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;


    public EmployeeNotFoundException(Long id) {
        super("Employee not found with id: " + id);
    }
}
