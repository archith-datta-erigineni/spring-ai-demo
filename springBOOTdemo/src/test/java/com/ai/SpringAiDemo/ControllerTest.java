package com.ai.SpringAiDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@WebMvcTest(Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @SuppressWarnings("removal")
    @MockBean
    private ChatService chatService;

    @Test
    void chatEndpointReturnsResponse() throws Exception {
        String userMessage = "Say hello";
        String aiResponse = "Hello!";
        when(chatService.chat(userMessage)).thenReturn(aiResponse);

        mockMvc.perform(post("/api/google-gemini/chat")
                .contentType("text/plain")
                .content(userMessage))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(aiResponse));
    }
}
