package com.example.demo.mapper;

//This class belongs to the service layer of REST architecture. It connects Controller to Repository and Repository to Controller...

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;


public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
	
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
		);
		
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
		);
		
	}
	
}
