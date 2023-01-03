package com.rakib.employeeservice.client;

import com.rakib.employeeservice.dto.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/employee")
public interface EmployeeService {

    @PostExchange
    Employee addEmployee(Employee employee);

    @GetExchange
    List<Employee> getEmployeeList();

    @GetExchange
    Employee getEmployee(@PathVariable Integer id);

}
