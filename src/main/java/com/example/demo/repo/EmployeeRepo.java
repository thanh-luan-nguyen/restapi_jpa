package com.example.demo.repo;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> { // first parameter is the model class that
    // will be managed by this repository, second is the data type of the primary key

}

// @Repository: indicates that the class is a data repository that will contain CRUD operations
// The @Repository annotation from the EmployeeRepo class enabled the creation of a bean
// of this class through the @ComponentScan feature of Spring. This bean is then used in the service
// class using @Autowired annotation. This is called Dependency Injection in Spring.