package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service // service layer of app , it's called from controler layer from @Controller annotation and contains the beans of the application
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Override //gets request with JSON data from @Controller and to pass it to @Reposiroty layer
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto); // from controller sends the data to Repository
		Employee savedEmployee = employeeRepository.save(employee); // sends the data to interface and the JpaRepository does automatically update to database
		return EmployeeMapper.mapToEmployeeDto(savedEmployee); // sends back the data for confirmation

	}

	@Override // http request from controller that requests the data of the employee with that Id
	public EmployeeDto getEmployeeById(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() ->
					new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);

		//sends to repositoryy layer the id data and employeeRepository makes the transacrtion with the db automatically and sends back the data of person with that id
	}

	@Override //returns all the persons employees saved in the database
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override //this method from @Controller sends to @Repository layer to search in database the person with that id and if it finds will update the row of that id with the data sent with JSON
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
				new ResourceNotFoundException("Employee is not exists with that given id: " + employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override // From @Controller takes the http request and sends to @Repository to find in database the person with that id and delete from tablee that row. If does not exists returns an error with a custor message
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() ->
						new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

		employeeRepository.deleteById(employeeId);
	}

}
