package com.repository;

import com.database.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {

    @Query(value = "select f from ComplaintEntity f where f.checker = false ")
    LinkedList<ComplaintEntity> dateSelect();

    @Modifying
    @Transactional
    @Query("update ComplaintEntity u set u.answer = :emailHash, u.checker = true where u.id = :id")
    void updateComplaint(@Param("emailHash") String email, @Param("id") int id);
//
//    @Modifying
//    @Query("update ComplaintEntity u set u.answer = ?1, u.checker = true where u.id = ?2")
//    void updateComplaint(String answer, int userId);

    ComplaintEntity findById(int id);

    List<ComplaintEntity> findComplaintEntitiesById(int id_customers);

    List<ComplaintEntity> findComplaintEntitiesByIdNotNull();
}
