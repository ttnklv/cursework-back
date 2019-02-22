package com.repository;

import com.database.GalleryFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryFilmRepository extends JpaRepository<GalleryFilmEntity, Long> {
}
