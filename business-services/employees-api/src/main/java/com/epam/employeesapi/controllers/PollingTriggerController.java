package com.epam.employeesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polling")
public class PollingTriggerController {
    @Autowired
    private IntegrationFlow flow;

    public void poll() {
        flow.getInputChannel().send(new GenericMessage<Void>(null));
    }
}
