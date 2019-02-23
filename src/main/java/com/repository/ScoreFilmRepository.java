package com.repository;

import com.database.ScoreFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreFilmRepository extends JpaRepository<ScoreFilmEntity,Long> {
    List<ScoreFilmEntity> findAllByIdFilm(int id_film);

}
