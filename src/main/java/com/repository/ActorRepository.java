package com.repository;

import com.database.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
    ActorEntity findByIdActor(int id);
}
