package com.epam.employeesapi.services.interfaces;

import com.epam.commons.entity.Employee;
import org.springframework.boot.ApplicationArguments;

public interface EmployeeInterface {
    Employee findEmployee(String id);
    void addEmployee(Employee employee);
}
