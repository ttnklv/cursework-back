package com.repository;

import com.database.AnalystEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

public interface AnalystRepository extends JpaRepository<AnalystEntity, Long> {

    @Query(value = "select d from AnalystEntity d where d.idAnalyst = :id")
   AnalystEntity findByIdt(@Param("id") int id);

    AnalystEntity findByIdAnalyst(int id_analyst);

    @Modifying
    @Transactional
    @Query("update AnalystEntity u set u.purse = :purse where u.id = :id")
    void updatePurse(@Param("purse") long purse, @Param("id") int id);
}



