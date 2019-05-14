package com.epam.employeesapi.configuration;

import com.epam.commons.api.WorkspaceAPI;
import com.epam.employeesapi.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class KafkaIntegrationConfig {
    private final EmployeeService employeeService;
    private final WorkspaceAPI workspaceAPIClient;

    /* Работает через программу tool 2*/
//    @Bean
//    public IntegrationFlow fromKafkaFlow(ConsumerFactory<?, ?> consumerFactory) {
//        return IntegrationFlows
//            .from(Kafka.messageDrivenChannelAdapter(consumerFactory, "test"))
//            .log("from topic")
//            .handle(message ->
//                    log.info(" {}", employeeService.findEmployee(workspaceAPIClient.getWorkspaceById((String) message.getPayload()).getId()))).get();
//
//    }


}
