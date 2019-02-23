package com.controllers;

import com.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerChat {

    private final ChatService chatService;

    @Autowired
    public ControllerChat(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/setMes")
    String setMes() {
        return chatService.returnSetMes();
    }

    @GetMapping("/getMes")
    String getMes() {
        List<String> chatMes = chatService.returnMessageContent();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < chatMes.size() - 1; i++) {
            if (i % 2 == 0) answer.append("Дата сообщения").append(chatMes.get(i));
            else answer.append("Само сообщение").append(chatMes.get(i + 1));
        }
        return String.valueOf(answer);
    }

    @GetMapping("/addUserInChat")
    Boolean addUser() {
        return chatService.checkUserInChat();
    }

    @GetMapping("/addChatToUser")
    String addUserToChat() {
        return chatService.addNewChat();
    }

    @GetMapping("/getAllChatsForUser")
    String getAllChatsForUser() {
        return chatService.findAllChatsForUser();
    }
}