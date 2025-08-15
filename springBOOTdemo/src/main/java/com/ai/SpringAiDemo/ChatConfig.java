package com.ai.SpringAiDemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.ai.chat.client.ChatClient;
// import org.springframework.ai.chat.model.ChatModel;


@Configuration
public class ChatConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}