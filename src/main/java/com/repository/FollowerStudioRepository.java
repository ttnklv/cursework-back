package com.repository;


import com.database.FollowerStudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowerStudioRepository extends JpaRepository<FollowerStudioEntity, Long> {



    @Transactional
    @Modifying
    void deleteAllByIdCustomersLikeAndIdStudioLike(int id_customers, int id_studio);

    List<FollowerStudioEntity> findByIdCustomers(int id);


}
