package com.example.demo.entity;


//This class belongs to the Repository layer of the REST architecture that is describing how to manipulate data from OR to database table

//jakarta.persistence is an API maps java objects to relational database tables.
import jakarta.persistence.Entity; //annotation that says this class is an entity to map it to database table
import jakarta.persistence.Table; //annotation that says this class will be saved in that specific table of rdb
import jakarta.persistence.Id; //annotation that says this field is the primary key and gives a unique number
import jakarta.persistence.GeneratedValue; //GeneratedValue annotation is to generate automaticaly for the primary key new value for the table
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column; //This maps the field with the column of the table in the rdb

import lombok.AllArgsConstructor; // this librady used with the annotations to minimize the code of class such constructors , getters , setters
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //  Automatically generates getter methods for all fields in the class.
@Setter // Annotation generates setter methods for all fields in the class. It allows you to avoid manually writing methods to set the values of your fields.
@NoArgsConstructor // Generates a no-argument constructor. This is useful for creating instances without setting any fields
@AllArgsConstructor // Generates a constructor with one parameter for every field in class
@Entity //annotation that says that class is an entity to map for relational database table
@Table(name="employees") // this annotation specifies the name of the table inside the relational database we configured at DAO hibernate
public class Employee {
	@Id //annotation that says this field is the primary key and gives a unique number
	@GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue annotation is to generate for the primary key new value for the table //The strategy attribute defines how the primary key value is generated. This specifies that the primary key value should be generated automatically by the database upon insertion of a new record
	private Long id;
	
	@Column(name = "first_name") //This maps the field with the column called `first_name` of the table `employees` in the rdb
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id" , nullable = false , unique = true) //nullable = false attribute means this can't be null. unique attribute = true means that field but be only one in the collumn of the table rdb
	private String email;




	
	
}
