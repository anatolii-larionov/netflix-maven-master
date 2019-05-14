package com.epam.employeesapi.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Sender {
    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EmployeeService employeeService;

    @Value("${app.topic.foo}")
    private String topic;

    public void send(String message){
        LOG.info("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, employeeService.findEmployee(message).getWorkspaceId());
    }


}
