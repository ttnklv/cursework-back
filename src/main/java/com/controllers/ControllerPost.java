package com.controllers;

import com.database.PostTagEntity;
import com.service.GalleryService;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Collection;

@RestController
public class ControllerPost {

    private final PostService postService;
    private final GalleryService galleryService;

    @Autowired
    public ControllerPost(PostService postService, GalleryService galleryService) {
        this.postService = postService;
        this.galleryService = galleryService;
    }

    @GetMapping("/getPosts")
    String getPosts() {
        String answer = postService.getAllPosts();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/getAllPhotosOfTheFilm")
    String getAllPhotosOfTheFilm() {
        String answer = galleryService.getAllFilmGallery();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/getAllPhotosOfTheActor")
    String getAllPhotosOfTheActor() {
        String answer = galleryService.getAllActorGallery();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/getAllPhotosOfTheStudio")
    String getAllPhotosOfTheStudio() {
        String answer = galleryService.getAllStudioGallery();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/newPost") //хз на сет этого
    String newPost(){
        java.util.Date d = new java.util.Date();
        Date date = new Date(d.getYear(),d.getMonth(),d.getDay());
        Collection<PostTagEntity> postTags = null;
        postService.addNewPost(null,date,"body",1,postTags);
        return null;
    }

}
