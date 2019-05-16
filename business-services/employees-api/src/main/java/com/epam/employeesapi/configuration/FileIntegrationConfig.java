package com.epam.employeesapi.configuration;

import com.epam.employeesapi.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;

import javax.sql.DataSource;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class FileIntegrationConfig {
    private final EmployeeService employeeService;

    @Bean
    @InboundChannelAdapter(value = "insuranceIdsChannel", poller = @Poller(fixedDelay = "30000"))
    public MessageSource<?> storedProc(DataSource dataSource) {
        return new JdbcPollingChannelAdapter(dataSource, "SELECT * FROM employee");
    }

    @Bean
    public IntegrationFlow flow() {
        return IntegrationFlows.from("insuranceIdsChannel")
                .split()
                .transform(this::toCsvLineTransformer)
                .log(LoggingHandler.Level.INFO)
                .aggregate()
                .log(LoggingHandler.Level.INFO)
                .transform((List<String> lines) -> lines.stream().collect(Collectors.joining((System.lineSeparator()))))
                .handle(fileWritingMessageHandler())
                .log(LoggingHandler.Level.INFO)
                .get();
    }

    private String toCsvLineTransformer(Map messageSource) {
        log.info("received ms - " + messageSource);
        return new Date().toString() + ";" +  messageSource.get("id") + ";" + messageSource.get("workspace_id");
    }

    private FileWritingMessageHandler fileWritingMessageHandler() {
        Expression destinationDirectory = new LiteralExpression("resources/files/output");
        FileWritingMessageHandler fileWritingMessageHandler = new FileWritingMessageHandler(destinationDirectory);
        fileWritingMessageHandler.setFileExistsMode(FileExistsMode.APPEND);
        fileWritingMessageHandler.setAppendNewLine(true);
        fileWritingMessageHandler.setFileNameGenerator(message -> "file.csv");
        fileWritingMessageHandler.setExpectReply(true);
        return fileWritingMessageHandler;
    }
    @Bean
    public IntegrationFlow fileReadingFlow() {
        return IntegrationFlows
                .from(Files.inboundAdapter(new File("resources/files/input"))
                                .patternFilter("*.csv"),
                        e -> e.poller(Pollers.fixedDelay(5000)))
                .split(Files.splitter())
                .handle(message -> {
                    String csvString = (String) message.getPayload();
                    log.info(csvString);
                    String[] csvData = StringUtils.split(csvString, ";");
                    log.info(csvData[0] + ";" + csvData[1]);
                    employeeService.update(csvData[0], csvData[1]);
                })
                .get();
    }


}
