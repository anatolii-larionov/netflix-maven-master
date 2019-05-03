package com.epam.employeesapi.services;

import com.epam.commons.entity.Employee;
import com.epam.employeesapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeServiceInit implements ApplicationRunner {
    private final EmployeeRepository employeeRepository;

    private List<Employee> employees = Arrays.asList(
            new Employee("0000001", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000001"),
            new Employee("0000002", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000002"),
            new Employee("0000003", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000003"),
            new Employee("0000004", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000004"),
            new Employee("0000005", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000005"),
            new Employee("0000006", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000006"),
            new Employee("0000007", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000007"),
            new Employee("0000008", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000008"),
            new Employee("0000009", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000009"),
            new Employee("0000010", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000010"),
            new Employee("0000011", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000011"),
            new Employee("0000012", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000012"),
            new Employee("0000013", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000013"),
            new Employee("0000014", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000014"),
            new Employee("0000015", "Ivan", "Ivanov", "Ivan_Ivanov@corpmail.com", "0000015")
    );

    @Override
    public void run(ApplicationArguments args) {
        employees.forEach(employeeRepository::save);
    }
}
