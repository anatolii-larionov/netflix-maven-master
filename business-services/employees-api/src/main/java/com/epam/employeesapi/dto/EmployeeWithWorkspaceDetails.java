package com.epam.employeesapi.dto;

import com.epam.commons.entity.Workspace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeWithWorkspaceDetails {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Workspace workspace;
}
