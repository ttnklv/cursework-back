package com.service;

import com.database.MessageEntity;
import com.repository.DialogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class DialogueService {
    private final DialogueRepository dialogueRepository;

    @Autowired
    public DialogueService(DialogueRepository dialogueRepository) {
        this.dialogueRepository = dialogueRepository;
    }


//подается id analyst
    public int analystDialogs(int id) {

        ArrayList<Integer> dialIds = dialogueRepository.getAnalystDialogue(id);
        return dialIds.size();
    }

    //подается id analyst
    public int studioDialogs(int id) {

        ArrayList<Integer> dialIds = dialogueRepository.getStudioDialogue(id);
        return dialIds.size();
    }


    public String messageFromDiaogue(int id){
        //все сообщения конкретного диалога
        Collection<MessageEntity> messages = dialogueRepository.findById(id).getMessages();
        List<String> msgBodys  =new LinkedList<String>();
        for(MessageEntity msg:messages){
            msgBodys.add(msg.getBody());
        }

        return msgBodys.get(0);
    }

}
