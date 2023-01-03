package com.rakib.springboot3features.service;

import com.rakib.springboot3features.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee getEmployee(Integer id) {
        return employeeList.stream().filter(employee -> Objects.equals(employee.id(), id))
                .findAny().orElseThrow(() -> new RuntimeException("Customer Not found with id " + id));
    }
}
