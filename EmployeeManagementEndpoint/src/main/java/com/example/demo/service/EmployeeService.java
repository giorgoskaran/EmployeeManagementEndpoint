package com.example.demo.service;


import com.example.demo.dto.EmployeeDto;
import java.util.List;


//this is the interface of class that belongs to the service layer of application that has the logic
//the methods of interface are the functionality of application


public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

	void deleteEmployee(Long employeeId);
}
