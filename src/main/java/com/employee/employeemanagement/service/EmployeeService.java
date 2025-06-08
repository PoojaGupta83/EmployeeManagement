package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entities.Employee;
import com.employee.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.employeemanagement.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }
    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    public Employee update(Long id, Employee updatedEmployee) {
        Employee existingEmployee=repo.findAll()
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return repo.save(updatedEmployee);
    }

    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public void delete( Long id){
        Employee employee=repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        repo.delete(employee);
    }
}
