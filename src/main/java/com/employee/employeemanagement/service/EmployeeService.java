package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entities.Employee;
import com.employee.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.employeemanagement.exception.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }


    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // Ensure the updated employee has the same ID as the existing one
    // This is important to maintain the integrity of the database record
    public Employee update(Long id, Employee updatedEmployee) {
        Employee existingEmployee=repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
     Employee  savedData=persistEmpData(existingEmployee,updatedEmployee);
        savedData.setId(existingEmployee.getId());
       return repo.save(savedData);
    }

    private Employee persistEmpData(Employee existingEmployee,Employee updatedEmployee) {
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setCity(updatedEmployee.getCity());
        existingEmployee.setState(updatedEmployee.getState());
        existingEmployee.setCountry(updatedEmployee.getCountry());
        existingEmployee.setPinCode(updatedEmployee.getPinCode());
        existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        existingEmployee.setDateOfJoining(updatedEmployee.getDateOfJoining());
        return existingEmployee;
    }


    public void delete( Long id){
        Employee employee=repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        repo.delete(employee);
    }
}
