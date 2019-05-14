package com.epam.employeesapi.configuration;

import com.epam.commons.entity.Employee;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class FileIntegrationConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    @InboundChannelAdapter(value = "insuranceIdsChannel", poller = @Poller(fixedDelay="30000"))
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
                .transform((List<String> lines) -> lines.stream().collect(Collectors.joining(System.lineSeparator())))
                .handle(fileWritingMessageHandler())
                .log(LoggingHandler.Level.INFO)
                .get();
    }

    private String toCsvLineTransformer(Map messageSource) {
        log.info("received ms - " + messageSource);
        return messageSource.get("id") + "," + messageSource.get("first_name");
    }

    private FileWritingMessageHandler fileWritingMessageHandler() {
        Expression destinationDirectory = new LiteralExpression("D:/");
        FileWritingMessageHandler fileWritingMessageHandler = new FileWritingMessageHandler(destinationDirectory);
        fileWritingMessageHandler.setFileExistsMode(FileExistsMode.APPEND);
        fileWritingMessageHandler.setAppendNewLine(true);
        fileWritingMessageHandler.setFileNameGenerator(message -> "file.csv");
        fileWritingMessageHandler.setExpectReply(true);
        return fileWritingMessageHandler;
    }


}
