package com.repository;

import com.database.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedList;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity,Long> {

//    @Query(value = "select f from ComplaintEntity f where f.checker = 0")
//    LinkedList<ComplaintEntity> dateSelect();

    List<ComplaintEntity> findComplaintEntitiesById(int id_customers);

    List<ComplaintEntity> findComplaintEntitiesByIdNotNull();
}
