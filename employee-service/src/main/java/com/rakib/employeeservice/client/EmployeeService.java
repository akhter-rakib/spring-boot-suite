package com.rakib.employeeservice.client;

import com.rakib.employeeservice.dto.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("http://localhost:8080/employee")
public interface EmployeeService {

    @PostExchange
    Employee addEmployee(@RequestBody Employee employee);

    @GetExchange
    List<Employee> getEmployeeList();

    @GetExchange("/{id}")
    Employee getEmployee(@PathVariable Integer id);

}
