package botService;

import botBase.PostEntity;
import botRep.PostRep;

import java.util.List;

public class PostService {

    private PostRep post = new PostRep();

    public List<PostEntity> findPostsBySub(int id){
        return post.findNewPostByFollower(id);
    }
}
