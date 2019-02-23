package com.repository;

import com.database.ScoreActorEntity;
import com.database.ScoreAnalystEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreAnalystRepository extends JpaRepository<ScoreAnalystEntity, Long> {

    List<ScoreAnalystEntity> findAllByIdAnalyst(int id_analyst);

}
