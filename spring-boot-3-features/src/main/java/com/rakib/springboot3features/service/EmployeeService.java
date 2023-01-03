package com.rakib.springboot3features.service;

import com.rakib.springboot3features.dto.Employee;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final ObservationRegistry registry;
    List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return Observation.createNotStarted("addEmployee", registry).observe(() -> employee);

    }

    public List<Employee> getEmployeeList() {
        return Observation.createNotStarted("getEmployeeList", registry).observe(() -> employeeList);
    }

    public Employee getEmployee(Integer id) {
        return Observation.createNotStarted("getEmployee", registry).observe(() ->
                employeeList.stream().filter(employee -> Objects.equals(employee.id(), id))
                        .findAny().orElseThrow(() -> new RuntimeException("Customer Not found with id " + id)));

    }
}
