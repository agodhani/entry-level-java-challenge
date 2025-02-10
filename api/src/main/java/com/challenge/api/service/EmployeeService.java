package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeClass;
import java.time.Instant;
import java.util.*;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {
    private Map<UUID, Employee> employeeMap = new HashMap<>();

    public EmployeeService() {
        // creates sample data
        Employee emp1 = new EmployeeClass();
        emp1.setUuid(UUID.randomUUID());
        emp1.setFirstName("Akshay");
        emp1.setLastName("Godhani");
        emp1.setFullName(emp1.getFirstName() + " " + emp1.getLastName());
        emp1.setAge(21);
        emp1.setSalary(1000000);
        emp1.setJobTitle("Developer");
        emp1.setEmail("akshaysamazingemaile@validemail.com");
        emp1.setContractHireDate(Instant.now());
        employeeMap.put(emp1.getUuid(), emp1);

        Employee emp2 = new EmployeeClass();
        emp2.setUuid(UUID.randomUUID());
        emp2.setFirstName("My");
        emp2.setLastName("Roomate");
        emp2.setFullName(emp2.getFirstName() + " " + emp2.getLastName());
        emp2.setAge(22);
        emp2.setSalary(10);
        emp2.setJobTitle("Existing");
        emp2.setEmail("myroomatesmells@joking.com");
        emp2.setContractHireDate(Instant.now());
        employeeMap.put(emp2.getUuid(), emp2);
    }

    public List<Employee> getAllEmployees() {
        // Returns all values in hashmap for employees
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        // Returns employee if exists otherwise throws not_found exception
        Employee employee = employeeMap.get(uuid);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee uuid doesn't exist");
        }
        return employee;
    }

    public Employee createEmployee(EmployeeClass requestEmployee) {
        // throw bad request
        if (requestEmployee == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create null Employee");
        }
        Employee emp1 = new EmployeeClass();
        // ensure request contains valid values
        if (requestEmployee.getFirstName() != null
                && requestEmployee.getLastName() != null
                && requestEmployee.getAge() != null
                && requestEmployee.getSalary() != null
                && requestEmployee.getEmail() != null
                && requestEmployee.getContractHireDate() != null
                && requestEmployee.getJobTitle() != null) {

            if (emp1.getUuid() != null) {
                emp1.setUuid(requestEmployee.getUuid());
            } else {
                emp1.setUuid(UUID.randomUUID());
            }

            // set the information from json
            emp1.setFirstName(requestEmployee.getFirstName());
            emp1.setLastName(requestEmployee.getLastName());
            emp1.setFullName(requestEmployee.getFirstName() + " " + requestEmployee.getLastName());
            emp1.setAge(requestEmployee.getAge());
            emp1.setSalary(requestEmployee.getSalary());
            emp1.setJobTitle(requestEmployee.getJobTitle());
            emp1.setEmail(requestEmployee.getEmail());
            emp1.setContractHireDate(requestEmployee.getContractHireDate());
            employeeMap.put(emp1.getUuid(), emp1);
            return emp1;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create Employee");
    }
}
