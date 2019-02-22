package com.repository;

import com.database.ScoreStudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreStudioRepository extends JpaRepository<ScoreStudioEntity, Long> {
    List<ScoreStudioEntity> findAllByIdStudio(int id_studio);

}
