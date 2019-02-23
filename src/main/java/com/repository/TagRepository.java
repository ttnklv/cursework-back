package com.repository;

import com.database.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findAll();

    TagEntity findById(int id_tag);
}
