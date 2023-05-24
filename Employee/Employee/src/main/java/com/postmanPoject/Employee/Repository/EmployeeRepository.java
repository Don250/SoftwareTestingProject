package com.postmanPoject.Employee.Repository;

import com.postmanPoject.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
