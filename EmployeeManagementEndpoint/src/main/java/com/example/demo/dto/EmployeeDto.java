package com.example.demo.dto;

//DTO(data transfer object) for employee to spring app to rdb visa versa

//This Employee class is the class for the controller layer or REST




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	
	
}
