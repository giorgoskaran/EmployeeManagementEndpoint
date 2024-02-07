package com.example.demo.repository;

//this interface will give functionality to employee entity and connects to relational database when user sends http requests.

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;   // Provides CRUD functionality for the entity. // methods for operations saving, deleting, and finding entities
// provides common persistence methods, such as save(), findById(), findAll(), deleteById()


//Employee: This is the entity class that the repository will manage
//Long: This specifies the type of the primary key of the Employee entity
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

}
