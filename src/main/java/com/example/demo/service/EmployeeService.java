package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo empRepo;

    // CREATE
    public Employee createEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    // READ
    public List<Employee> findAllEmployees() {
        return empRepo.findAll();
    }
    public Optional<Employee> findEmployeeById(Long id) {
        return empRepo.findById(id);
    }


    // DELETE
    public void deleteEmployee(Long empId) {
        empRepo.deleteById(empId);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee empDetails) {
        Employee emp = empRepo.findById(id).get();
        emp.setName(empDetails.getName());
        emp.setEmailId(empDetails.getEmailId());

        return empRepo.save(emp);
    }
}
