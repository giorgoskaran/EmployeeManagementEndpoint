package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import java.util.List;


@AllArgsConstructor
@RestController					  // Annotation for using class for controller layer and handling http requests
@RequestMapping("/api/employees") // this class will handle http requests that are coming from that path
public class EmployeeController {
	
	private EmployeeService employeeService;


	//Build Add Employee REST API
	@PostMapping //annotation for handling http post requests
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){ //parameter employeeDto will be bound with the data of the http request from @RequestBody annotation

		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto); // inject data to service layer and after to save it to database
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}



	//get Employee REST API
	@GetMapping("{id}") //annotation that handling get http requests with the path includes a long int variable representing the id of employee
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){  //the value of id in the URL from http request is saved to employeeId
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId); //passing to service layer from that bean and passing the request to database.
		return ResponseEntity.ok(employeeDto); //returns employee data from database and http status data
	}



	//get all employees REST API
	@GetMapping //annotation that handling get http request
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees(); //passing to service layer from that bean and passing the request to database.
		return ResponseEntity.ok(employees);  //retuns a list of objects employees with http status back to controller
	}

	//update employee by id REST API
	@PutMapping("{id}") //annotation that handles put http requests with long int at the url path
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){ //passing the int id to service layer from that bean and passing the request to database. @RequestBody will take more that that will change to database
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);//passing to service layer from that bean and passing the request to database.
		return ResponseEntity.ok(employeeDto);  //returns a object employeeDto with http status back to controller
	}

	//delete employee by id if this id exists REST API
	@DeleteMapping("{id}") //annotation that handles delete http requests..
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){   //the value of id in the URL from http request is saved to employeeId
		employeeService.deleteEmployee(employeeId);   //passing to service layer from that bean and passing the request to database to delete the user.
		return ResponseEntity.ok("Employee deleted successfully!.");               //returns a object employeeDto with http status back to controller and a message
	}


}
