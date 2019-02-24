package com.repository;

import com.database.PostTagEntity;
import com.database.PostTagEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Long> {
}
