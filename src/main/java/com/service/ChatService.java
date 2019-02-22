package com.service;

import com.database.ChatEntity;
import com.database.ChatUserEntity;
import com.repository.ChatRepository;
import com.repository.ChatUserRepository;
import com.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatUserRepository chatUserRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository, ChatUserRepository chatUserRepository, FilmRepository filmRepository) {
        this.chatRepository = chatRepository;
        this.chatUserRepository = chatUserRepository;
        this.filmRepository = filmRepository;
    }

    public String returnSetMes() {
        try {
            Date date = new Date();
            ChatEntity chatEntity = new ChatEntity();
            chatEntity.setCreateDate((java.sql.Date) date);
            chatEntity.setMsg("cool");
            chatEntity.setFilmId(1);
            chatEntity.setUserUsId(1);
            chatRepository.save(chatEntity);
            return "ok";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public List<String> returnMessageContent() {
        try {
            Integer film_id = 1;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            List<String> mes = new LinkedList<>();

            List<ChatEntity> entities = chatRepository.findByFilmId(film_id);
            for (ChatEntity entity : entities) {
                mes.add(dateFormat.format(entity.getCreateDate()));
                mes.add(entity.getMsg());
                if (mes.size() > 20) return mes;
            }
            return mes;
        } catch (NullPointerException ex) {
            return null;
        }
    }


     public boolean checkUserInChat() {
        try {
            return chatRepository.findAllByUserUsId(1).size() > 0;
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public String addNewChat() {
        try {
            ChatUserEntity chatUserEntity = new ChatUserEntity();
            chatUserEntity.setIdChat(1);
            chatUserEntity.setIdUs(1);
            chatUserRepository.save(chatUserEntity);
            return "User added chat";
        } catch (NullPointerException ex) {
            return "Error, user not added";
        }
    }

    public String findAllChatsForUser() {
        try {
            int id_user = 1;
            List<ChatEntity> chatEntities = chatRepository.findAllByUserUsId(id_user);
            StringBuilder chatNames = new StringBuilder();
            for (ChatEntity chatEntity : chatEntities) {
                chatNames.append("  Chat Name:  ")
                        .append(chatEntity.getFilm().getName());
            }
            return String.valueOf(chatNames);
        } catch (NullPointerException ex) {
            return "Ошибка";
        }
    }

    public String findChatForFilm() {
        try {
            List<ChatEntity> chatEntities = chatRepository.findAll();
            int film_id = 1;
            ChatEntity chatInfo;
            for (int i = 0; i < chatEntities.size(); i++) {
                if (chatEntities.get(i).getFilmId() == film_id) {
                    chatInfo = chatEntities.get(i);
                }
            }
            return "Find chat Entity for film";
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
