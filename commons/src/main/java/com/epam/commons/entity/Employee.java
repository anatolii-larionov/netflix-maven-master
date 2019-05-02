package com.epam.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String workspaceId;
}
