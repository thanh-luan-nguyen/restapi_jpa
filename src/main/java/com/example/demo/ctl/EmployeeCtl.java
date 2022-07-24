package com.example.demo.ctl;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeCtl {

    // @RestController on the class is a combination of:
    // @Controller - tells Spring Boot that this class is a controller.
    // @ResponseBody - indicates that the return value of the methods inside the controller
    // will be returned as the response body for the REST API.
    // EmployeeService is injected as a dependency using @Autowired annotation.

    @Autowired
    EmployeeService employeeService;

    // CREATE
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee emp) {
        log.info("create employees: " + emp.toString());
        // @RequestBody annotation is used to map the request body of the endpoint to the
        // method parameter. emp will contain the request JSON passed to this endpoint.

        return employeeService.createEmployee(emp);
    }

    // READ
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findEmployee(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    // UPDATE
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee emp) {
        return employeeService.updateEmployee(id, emp);
    }

    // DELETE
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
    }
}

