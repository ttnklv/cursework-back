package com.service;

import com.database.GalleryActorEntity;
import com.database.GalleryFilmEntity;
import com.database.GalleryStudioEntity;
import com.repository.GalleryActorRepository;
import com.repository.GalleryFilmRepository;
import com.repository.GalleryStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {
    private final GalleryActorRepository galleryActorRepository;
    private final GalleryStudioRepository galleryStudioRepository;
    private final GalleryFilmRepository galleryFilmRepository;

    @Autowired
    public GalleryService(GalleryActorRepository galleryActorRepository,
                          GalleryStudioRepository galleryStudioRepository,
                          GalleryFilmRepository galleryFilmRepository) {
        this.galleryActorRepository = galleryActorRepository;
        this.galleryFilmRepository = galleryFilmRepository;
        this.galleryStudioRepository = galleryStudioRepository;
    }

    public String getAllFilmGallery() {
        try {
            List<GalleryFilmEntity> galleryFilmEntities = galleryFilmRepository.findAll();
            return "All was saved in list.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String getAllActorGallery() {
        try {
            List<GalleryActorEntity> galleryActorEntities = galleryActorRepository.findAll();
            return "All was saved in list.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String getAllStudioGallery() {
        try {
            List<GalleryStudioEntity> galleryStudioEntities = galleryStudioRepository.findAll();
            return "All was saved in list.";
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
