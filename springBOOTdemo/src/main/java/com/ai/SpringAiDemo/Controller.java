package com.ai.SpringAiDemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/google-gemini")
public class Controller {

    private final ChatService ChatService;

    public Controller(ChatService ChatService) {
        this.ChatService = ChatService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody String message) {
        return new ChatResponse(this.ChatService.chat(message));
    }

    public record ChatResponse(String message) {}
}