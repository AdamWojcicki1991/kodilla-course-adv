package com.kodilla.exercise.configuration;

import com.kodilla.exercise.transform.FileTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

import static org.springframework.integration.file.support.FileExistsMode.REPLACE;

@Configuration
public class FileIntegrationConfiguration {
    @Bean
    IntegrationFlow fileIntegrationFlow(FileReadingMessageSource fileAdapter, FileTransformer transformer, FileWritingMessageHandler outputFileHandler) {
        return IntegrationFlows.from(fileAdapter, config -> config.poller(Pollers.fixedDelay(1000,0)))
                .transform(transformer, "transformFile")
                .handle(outputFileHandler)
                .get();
    }

    @Bean
    FileReadingMessageSource fileAdapter() {
        FileReadingMessageSource fileSource = new FileReadingMessageSource();
        fileSource.setDirectory(new File("./integration-exercise/data/input"));
        return fileSource;
    }

    @Bean
    FileTransformer transformer() {
        return new FileTransformer();
    }

    @Bean
    FileWritingMessageHandler outputFileAdapter() {
        File directory = new File("./integration-exercise/data/output");
        FileWritingMessageHandler handler = new FileWritingMessageHandler(directory);
        handler.setExpectReply(false);
        handler.setAppendNewLine(true);
        handler.setFileExistsMode(REPLACE);
        handler.setFileNameGenerator(message -> "files.txt");
        return handler;
    }
}
