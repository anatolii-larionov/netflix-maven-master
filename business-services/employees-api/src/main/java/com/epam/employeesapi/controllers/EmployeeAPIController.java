package com.epam.employeesapi.controllers;

import com.epam.commons.api.WorkspaceAPI;
import com.epam.commons.entity.Employee;
import com.epam.employeesapi.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.epam.employeesapi.dto.EmployeeWithWorkspaceDetails;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeAPIController {
    private final EmployeeService employeeService;
    private final WorkspaceAPI workspaceAPIClient;

    @RequestMapping("/{id}")
    public Employee describeEmployee(@PathVariable("id") String id) {
        return employeeService.findEmployee(workspaceAPIClient.getWorkspaceById(id).getId());
    }


    /*Метод с помощью dto вытаскивает информацию о employee и workspace без БД*/
//    @RequestMapping("/{id}")
//    public EmployeeWithWorkspaceDetails describeEmployeeWithWorkspace(@PathVariable("id") String id) {
//        Employee employee = employeeService.findEmployee(id);
//        EmployeeWithWorkspaceDetails employeeWithWorkspaceDetails = new EmployeeWithWorkspaceDetails();
//        employeeWithWorkspaceDetails.setId(employee.getId());
//        employeeWithWorkspaceDetails.setFirstName(employee.getFirstName());
//        employeeWithWorkspaceDetails.setLastName(employee.getLastName());
//        employeeWithWorkspaceDetails.setEmail(employee.getEmail());
//        employeeWithWorkspaceDetails.setWorkspace(workspaceAPIClient.getWorkspaceById(employee.getWorkspaceId()));
//        return employeeWithWorkspaceDetails;
//    }
}
