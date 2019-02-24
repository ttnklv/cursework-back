package com.controllers;

import com.service.DialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDialgues {
    private final DialogueService dialogueService;

    @Autowired
    public ControllerDialgues(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }

    @GetMapping("/dialogsForAnalyst")
    String dialogsForAnalyst(@RequestParam("id_analyst") int id_analyst) {
        return dialogueService.analystDialogs(id_analyst);
    }

    @GetMapping("/dialogsForStudio")
    String dialogsForStudio(@RequestParam("id_studio") int id_studio) {
        return dialogueService.studioDialogs(id_studio);
    }

    @GetMapping("/getMessagesFromDialogue")
    String getMessagesFromDialogue(@RequestParam("id_dialogue") int id_dialogue) {
        return dialogueService.messageFromDiaogue(id_dialogue);
    }

    @GetMapping("/setMessage")
    String setMessage(@RequestParam("id_analyst") int id_analyst,
                    @RequestParam("id_studio") int id_studio,
                    @RequestParam("message") String message) {
        dialogueService.setMessages(id_studio, id_analyst, message);
        return "ok";
    }

}
