package com.controllers;

import com.database.PostTagEntity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.CustomersService;
import com.service.GalleryService;
import com.service.PostService;
import com.service.TagService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;

@RestController
public class ControllerPost {

    private final PostService postService;
    private final GalleryService galleryService;
    private final CustomersService customersService;
    public final TagService tagService;

    @Autowired
    public ControllerPost(PostService postService, GalleryService galleryService, CustomersService customersService, TagService tagService) {
        this.postService = postService;
        this.galleryService = galleryService;
        this.customersService = customersService;
        this.tagService = tagService;
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



    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public ResponseEntity newPost(@RequestParam("username") String username,
                                  @RequestParam("body") String body,
                                  @RequestParam("img") String img)
  {
        java.util.Date d = new java.util.Date();
        Date date = new Date(d.getYear(), d.getMonth(), d.getDay());
        Collection<PostTagEntity> postTags = null;
        postService.addNewPost(img, date, body, customersService.findByLog(username).getId(), null);
        return ResponseEntity.ok(true);
    }
    final char dm = (char) 34;

    //Todo добавить теги к посту херово работает
//    @RequestMapping(value = "/setTags", method = RequestMethod.POST)
//    public ResponseEntity addTag(@RequestParam("id") int id,
//                                 @RequestParam("bodyTags") String body,
//                                 @RequestParam("img") String img) {
    @GetMapping("/setTags")
            public ResponseEntity setTag(){
        StringBuilder builder = new StringBuilder();
        builder.append("[{");
        builder.append(dm);
        builder.append("tag");
        builder.append(dm);
        builder.append(":");
        builder.append(dm);
        builder.append("кек");
        builder.append(dm);
        builder.append("}, {");
        builder.append(dm);
        builder.append("tag");
        builder.append(dm);
        builder.append(":");
        builder.append(dm);
        builder.append("лол");
        builder.append(dm);
        builder.append("}]");
        JSONArray jsonArray = new JSONArray(builder.toString());

        for(int i=0; i<jsonArray.length(); i++){
            try {
                JSONObject json =(JSONObject) (jsonArray.get(i));
                String someString = json.getString("tag");
                System.out.println(tagService.findTag(someString).getId());
                postService.addTagForPost(2, 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok(true);
    }
}
