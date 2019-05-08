package com.epam.employeesapi.services;

import com.epam.commons.entity.Employee;
import com.epam.employeesapi.configuration.EmployeesStream;
import com.epam.employeesapi.repository.EmployeeRepository;
import com.epam.employeesapi.services.interfaces.EmployeeInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService implements EmployeeInterface {
    private final EmployeeRepository employeeRepository;
    private final EmployeesStream employeesStream;

    @Override
    public Employee findEmployee(String id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void sendEmployee(final Employee employee) {
        log.info("SENTING MESSAGE {}", employee);

        MessageChannel messageChannel = employeesStream.outboundGreetings();
        messageChannel.send(MessageBuilder
        .withPayload(employee)
        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
        .build());
    }



    /*Метод работает без БД*/
/*    public Employee findEmployee(String id) {
        return employees.stream()
                .filter(employee -> StringUtils.equals(employee.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoEmployeeFoundException(format("No employee found for id: %s", id)));
    }*/
}
