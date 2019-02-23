package com.repository;

import com.database.FilmTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmTagRepository extends JpaRepository<FilmTagEntity, Long> {
    List<FilmTagEntity> findAllByIdTag(int id);
}
