package com.repository;

import com.database.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findAll();

    TagEntity findById(int id_tag);

    @Query(value = "select a from TagEntity a where a.tagName= :log")
    TagEntity findByTagName(@Param("log") String log);
}
