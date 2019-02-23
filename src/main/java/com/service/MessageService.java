package com.service;

import com.database.DialogueEntity;
import com.database.MessageEntity;
import com.repository.DialogueRepository;
import com.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final DialogueRepository dialogueRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, DialogueRepository dialogueRepository) {
        this.messageRepository = messageRepository;
        this.dialogueRepository = dialogueRepository;
    }

    public void setNewMessage(int idStudio, int idAnalyst, String body, Date d){
        Integer dialogue = dialogueRepository.getDialogue(idAnalyst,idStudio).getId();
        if ( dialogue == null) {
            DialogueEntity dial = new DialogueEntity();
            dial.setIdAnalyst(idAnalyst);
            dial.setIdStudio(idStudio);
            dialogueRepository.save(dial);
            dialogue = dialogueRepository.getDialogue(idAnalyst,idStudio).getId();
        }
        MessageEntity msg = new MessageEntity();
        msg.setIdAnalyst(idAnalyst);
        msg.setIdStudio(idStudio);
        msg.setBody(body);
        msg.setCreateDate(d);
        msg.setIdDialogue(dialogue);
        messageRepository.save(msg);
    }

}
