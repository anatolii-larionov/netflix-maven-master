package com.epam.employeesapi.services.interfaces;

import com.epam.commons.entity.Employee;

public interface EmployeeInterface {
    Employee findEmployee(String id);
}
