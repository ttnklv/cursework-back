package com.controllers;

import com.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFollowers {

    private final FollowerService followerService;

    @Autowired
    public ControllerFollowers(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping("/subscribeOnActor")
    String subscribeOnActor() {
        String answer = followerService.insertIntoFollowerActor();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/subscribeOnAnalyst")
    String subscribeOnAnalyst() {
        String answer = followerService.insertIntoFollowerAnalyst();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/subscribeOnStudio")
    String subscribeOnStudio() {
        String answer = followerService.insertIntoFollowerStudio();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/deleteFollowerStudio")
    String deleteFollowerStudio() {
        followerService.deleteFollowersStudio();
        return "Delete if was in the table";
    }

    @GetMapping("/deleteFollowerActor")
    String deleteFollowerActor() {
        followerService.deleteFollowersActor();
        return "Delete if was in the table";
    }

    @GetMapping("/deleteFollowerAnalyst")
    String deleteFollowerAnalyst() {
        followerService.deleteFollowersAnalyst();
        return "Delete if was in the table";
    }

    @GetMapping("/getPhotoForFollowersActor")
    String getPhotoForFollowersActor() {
        String img = followerService.getForFollowerIMGOfActor();
        if (img != null)
            return img;
        return "Not found photo";
    }

    @GetMapping("/getPhotoForFollowersAnalyst")
    String getPhotoForFollowersAnalyst() {
        String img = followerService.getForFollowerIMGOfAnalyst();
        if (img != null)
            return img;
        return "Not found photo";
    }

    @GetMapping("/getPhotoForFollowersStudio")
    String getPhotoForFollowersStudio() {
        String img = followerService.getForFollowerIMGOfStudio();
        if (img != null)
            return img;
        return "Not found photo";
    }
}
