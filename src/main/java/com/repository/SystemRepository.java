package com.repository;

import com.database.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemRepository extends JpaRepository<SystemEntity, Long> {

    SystemEntity findById(int id);
}
