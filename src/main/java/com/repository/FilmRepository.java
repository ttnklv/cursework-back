package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.database.FilmEntity;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.LinkedList;

public interface FilmRepository extends JpaRepository<FilmEntity,Long> {

    @Query(value = "select f from FilmEntity f where f.createDate <= current_date and f.createDate >=( current_date) - 10 ")
    LinkedList<FilmEntity> dateSelect();

    FilmEntity findById(int id);


    @Query(value = "SELECT f from film f" +
            " join film_tag ft on f.id = ft.id_film join" +
            " tag t on ft.id_tag = t.id order by t.count desc", nativeQuery = true)
    LinkedList<FilmEntity> popularFilmForFeed();

}
