package com.repository;


import com.database.FollowerActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowerActorRepository extends JpaRepository<FollowerActorEntity, Long> {


    @Transactional
    @Modifying
    void deleteAllByIdCustomersLikeAndIdActorLike(int id_customers, int id_actor);

    List<FollowerActorEntity> findByIdCustomers(int id_actor);
}
