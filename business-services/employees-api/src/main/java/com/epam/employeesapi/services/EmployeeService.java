package com.epam.employeesapi.services;

import com.epam.commons.entity.Employee;
import com.epam.employeesapi.repository.EmployeeRepository;
import com.epam.employeesapi.services.interfaces.EmployeeInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService implements EmployeeInterface {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployee(String id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }



    /*Метод работает без БД*/
/*    public Employee findEmployee(String id) {
        return employees.stream()
                .filter(employee -> StringUtils.equals(employee.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoEmployeeFoundException(format("No employee found for id: %s", id)));
    }*/
}
