package com.epam.employeesapi.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(EmployeesStream.class)
public class StreamConfig {
}
