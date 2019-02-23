package com.repository;

import com.database.FilmEntity;
import com.database.GenreFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.LinkedList;

public interface GenreFilmRepository extends JpaRepository<GenreFilmEntity,Long> {
    //получила Id всех вильмов с жанром

    @Query(value = "select gf from GenreFilmEntity gf where gf.idGenre = :id ")
    LinkedList<GenreFilmEntity> filmsByGenre(@Param("id") int id );

}
