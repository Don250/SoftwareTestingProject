package com.postmanPoject.Employee;

import com.postmanPoject.Employee.Repository.EmployeeRepository;
import com.postmanPoject.Employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	@Autowired
	private EmployeeRepository  employeeRepository;
	@Override

	public void run(String...args) throws Exception{

		Employee 	employee= new Employee();
		employee.setEmpID("16789");
		employee.setFirstName_emp("Anne");
		employee.setLastName_emp("Isingizwe");
		employee.setEmp_salary("350000");
		employee.setEmp_phoneNo("0783567656");
		employee.setEpmEmail("anneisingizwe@gmail.com");
		employee.setEmp_password("ANNE");
		employeeRepository.save(employee);





	}
}
