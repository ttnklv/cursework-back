package com.repository;

import com.database.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    //все ревью аналитика по ид
    @Query(value = "select r.id from ReviewEntity r")
    HashSet<Integer> allId();

    @Query(value = "select r from ReviewEntity r where r.idAnalyst = :id ")
    LinkedList<ReviewEntity> reviewsForOneAnalyst(@Param("id") int id );

    @Query(value = "select r from ReviewEntity r where r.idFilm = :id ")
    LinkedList<ReviewEntity> allAnalystsForFilm(@Param("id") int id );

   // List<ReviewEntity> findAllByIdAnalyst(int id_analyst);

    List<ReviewEntity> findAllByIdFilm( int id_film);
}
