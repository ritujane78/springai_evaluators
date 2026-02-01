package com.jane.springai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.evaluation.FactCheckingEvaluator;
import org.springframework.ai.chat.evaluation.RelevancyEvaluator;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ChatClientConfig {

    @Bean
    @Qualifier("mainChatClient")
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .clone()
                .defaultAdvisors(
                        new SimpleLoggerAdvisor()
                )
                .defaultOptions(ChatOptions.builder()
                        .model("llama3.2:3b")
                        .maxTokens(250)
                        .build())
                .build();
    }

    @Bean
    public FactCheckingEvaluator factCheckingEvaluator(ChatClient.Builder builder) {
        ChatClient.Builder evaluatorBuilder = builder.clone()
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultOptions(ChatOptions.builder()
                        .model("bespoke-minicheck")
                        .maxTokens(100)
                        .build());

        return new FactCheckingEvaluator(evaluatorBuilder);
    }
    @Bean
    public RelevancyEvaluator relevancyEvaluator(ChatClient.Builder builder) {
        ChatClient.Builder evaluatorBuilder = builder.clone()
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultOptions(ChatOptions.builder()
                        .model("bespoke-minicheck")
                        .maxTokens(100)
                        .build());

        return new RelevancyEvaluator(evaluatorBuilder);
    }
}
