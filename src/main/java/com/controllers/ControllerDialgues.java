package com.controllers;

import com.service.DialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDialgues {
    private final DialogueService dialogueService;

    @Autowired
    public ControllerDialgues(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }

    @GetMapping("/dialogsForAnalyst")
    int dialogs(){
        return dialogueService.analystDialogs(1);
    }

    @GetMapping("/dialogsForStudio")
    int allDialogs(){
        return dialogueService.studioDialogs(1);
    }
}
