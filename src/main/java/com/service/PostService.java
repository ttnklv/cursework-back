package com.service;

import com.database.PostEntity;
import com.database.PostTagEntity;
import com.repository.CustomersRepository;
import com.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    public String getAllPosts() {
        try {
            List<PostEntity> postEntities = postRepository.findAll();
            return "All was saved in list.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void addNewPost(byte[] b, Date date, String body, Integer userUsOwnerId, Collection<PostTagEntity> postTags) {
        PostEntity pe = new PostEntity();
        pe.setImg(b);
        pe.setCreateDate(date);
        pe.setBody(body);
        pe.setUserUsOwnerId(userUsOwnerId);
        pe.setPostTags(postTags);
        postRepository.save(pe);
    }

    //TODO удалить пост / редактировать пост

//    public void deletePost(long id){
//        postRepository.deleteById(id);
//    }
//
//    //вроде можно было только тело отредачить хз
//    public void updatePost(int id, String body){
//        java.util.Date d = new java.util.Date();
//        Date date = new Date(d.getYear(), d.getMonth(), d.getDay());
//        postRepository.updatePostBody(body, id);
//        postRepository.updatePostDate(date, id);
//    }

}
