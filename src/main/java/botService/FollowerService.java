package botService;

import botBase.FollowerActorEntity;
import botBase.FollowerAnalystEntity;
import botBase.FollowerStudioEntity;
import botRep.Followers;

import java.util.List;

public class FollowerService {
    private Followers followers = new Followers();

    public List<FollowerActorEntity> findActors(int id){
        return followers.findAllActorsForUser(id);
    }

    public List<FollowerAnalystEntity> findAnalysts(int id){
        return followers.findAllAnalystForUser(id);
    }

    public List<FollowerStudioEntity> findStudios(int id){
        return followers.findAllStudiosForUser(id);
    }
}
