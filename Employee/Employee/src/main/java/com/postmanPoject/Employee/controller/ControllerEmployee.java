package com.postmanPoject.Employee.controller;


import com.postmanPoject.Employee.Repository.EmployeeRepository;
import com.postmanPoject.Employee.exception.ResouceNotFoundException;
import com.postmanPoject.Employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/emplo")
public class ControllerEmployee {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> findAll(){
        return  employeeRepository.findAll();


    }
    @PostMapping
    public  Employee save(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("{empID}")
    public ResponseEntity<Employee> findByID(@PathVariable String empID){
        Employee employee = employeeRepository.findById(empID).orElseThrow(() -> new ResouceNotFoundException("Car not exist with plate number:" +empID));

        return  ResponseEntity.ok(employee);
    }
    @PutMapping ("{empID}")
    public  ResponseEntity<Employee> update(@PathVariable String empID, @RequestBody Employee employeeDetails ){
        Employee employee = employeeRepository.findById(empID).orElseThrow(() -> new ResouceNotFoundException("Car not exist with plate number:" +empID));
        employee.setEmpID(employeeDetails.getEmpID());
        employee.setFirstName_emp(employeeDetails.getFirstName_emp());
        employee.setLastName_emp(employeeDetails.getLastName_emp());
        employee.setEmp_salary(employeeDetails.getEmp_salary());
        employee.setEmp_phoneNo(employeeDetails.getEmp_phoneNo());
        employee.setEpmEmail(employeeDetails.getEpmEmail());
        employee.setEmp_password(employeeDetails.getEmp_password());
        employeeRepository.save(employee);
        return  ResponseEntity.ok(employee);
    }
    @DeleteMapping("{empID}")
    public  ResponseEntity<HttpStatus>delete( @PathVariable String empID){
        Employee employeedata = employeeRepository.findById(empID).orElseThrow(()-> new ResouceNotFoundException("car not exist with plate number :" +empID));

        employeeRepository.delete(employeedata);
       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
