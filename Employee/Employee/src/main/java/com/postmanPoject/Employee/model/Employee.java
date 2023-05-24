package com.postmanPoject.Employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emplo")
public class Employee {
    @Id
    private String empID;
    private String firstName_emp;
    private String lastName_emp;
    private String emp_salary;
    private String emp_phoneNo;
    private String epmEmail;
    private String emp_password;
}
