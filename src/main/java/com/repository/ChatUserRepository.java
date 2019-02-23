package com.repository;


import com.database.ChatEntity;
import com.database.ChatUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ChatUserRepository extends JpaRepository<ChatUserEntity, Long> {


    List<ChatUserEntity> findAllByIdUs(int id_user);

//    List<ChatEntity> findChatUserEntityByIdUs
//    @Query(value = "SELECT c from chat c join chat_user on c.id = chat_user.id_chat where chat_user.id_us = :id_us", nativeQuery = true)
//    List<ChatEntity> findChatByUserId(@Param("id_us") Integer id_us);
}
