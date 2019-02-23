package com.repository;

import com.database.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    List<ChatEntity> findAll();

    List<ChatEntity> findAllByFilmIdIsLikeOrderByCreateDateAsc(int id_film);

    List<ChatEntity> findAllByUserUsId(int user_id);

    ChatEntity findById(int id);

    List<ChatEntity> findByFilmId(int id_film);

//    @Query(value = "SELECT * from chat c join chat_user on c.id = chat_user.id_chat where chat_user.id_us = :id_us")
//    List<ChatEntity> findChatByUserId(@Param("id_us") Integer id_us);

    List<ChatEntity> findChatEntitiesByUserUsId(int id_user);


}
