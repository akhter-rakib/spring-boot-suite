package com.rakib.employeeservice.controller;

import com.rakib.employeeservice.client.EmployeeService;
import com.rakib.employeeservice.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employee-service")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> fetchEmployees() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public Employee fetchEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
