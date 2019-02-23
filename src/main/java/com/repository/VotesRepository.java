package com.repository;

import com.database.VotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface VotesRepository extends JpaRepository<VotesEntity, Long> {



//    List<VotesEntity> findAllByFlagAccessLike(boolean access);
    List<VotesEntity> findAllByFlagAccess(boolean access);

    VotesEntity findById(int id);

//    List<VotesEntity> findAllByFilmByIdFilmIsLike(int id_film);
    //List<VotesEntity> findAllByFilmByIdFilm(int id_film);



    List<VotesEntity> findAllByIdFilm(int id_film);
    @Modifying
    @Transactional
    @Query("update VotesEntity u set u.countNegative = :countNegative where u.id = :id")
    void updateNegative(@Param("countNegative") int countNegative, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update VotesEntity u set u.countPositive = :countPositive where u.id = :id")
    void updatePositive(@Param("countPositive") int countPositive, @Param("id") int id);

}
