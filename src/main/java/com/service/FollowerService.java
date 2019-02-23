package com.service;

import com.database.*;
import com.repository.CustomersRepository;
import com.repository.FollowerActorRepository;
import com.repository.FollowerAnalystRepository;
import com.repository.FollowerStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class FollowerService {

    private final FollowerActorRepository followerActorRepository;
    private final FollowerAnalystRepository followerAnalystRepository;
    private final FollowerStudioRepository followerStudioRepository;
    private final CustomersRepository customersRepository;

    @Autowired
    public FollowerService(FollowerStudioRepository followerStudioRepository,
                           FollowerAnalystRepository followerAnalystRepository,
                           FollowerActorRepository followerActorRepository,
                           CustomersRepository customersRepository) {
        this.followerActorRepository = followerActorRepository;
        this.followerAnalystRepository = followerAnalystRepository;
        this.followerStudioRepository = followerStudioRepository;
        this.customersRepository = customersRepository;
    }

    public String insertIntoFollowerStudio() {
        try {
            FollowerStudioEntity followerStudioEntity = new FollowerStudioEntity();
            followerStudioEntity.setIdCustomers(1);
            followerStudioEntity.setIdCustomers(3);
            followerStudioRepository.save(followerStudioEntity);
            return "You signed up for the Studio";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String insertIntoFollowerActor() {
        try {
            FollowerActorEntity followerEntity = new FollowerActorEntity();
            followerEntity.setIdCustomers(1);
            followerEntity.setIdCustomers(3);
            followerActorRepository.save(followerEntity);
            return "You signed up for the Actor";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String insertIntoFollowerAnalyst() {
        try {
            FollowerAnalystEntity analystFollowerEntity = new FollowerAnalystEntity();
            analystFollowerEntity.setIdAnalyst(2);
            analystFollowerEntity.setIdCustomers(1);
            followerAnalystRepository.save(analystFollowerEntity);
            return "You signed up for the Analyst";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void deleteFollowersStudio() {
        try {
            followerStudioRepository.deleteAllByIdCustomersLikeAndIdStudioLike(1, 1);
        } catch (NullPointerException ignored) {
        }
    }

    public void deleteFollowersActor() {
        try {
            followerActorRepository.deleteAllByIdCustomersLikeAndIdActorLike(1, 1);
        } catch (NullPointerException ignored) {
        }
    }

    public void deleteFollowersAnalyst() {
        try {
            followerAnalystRepository.deleteAllByIdCustomersLikeAndIdAnalystLike(1, 1);
        } catch (NullPointerException ignored) {
        }
    }

    public String getForFollowerIMGOfStudio() {
        int id_customer = 1;
        String imgAndName = "";
        try {
            List<CustomersEntity> subscribeToTheStudios2 = new LinkedList<>();
            List<FollowerStudioEntity> subscribeToTheStudios = followerStudioRepository.findAll();
            for(FollowerStudioEntity follower: subscribeToTheStudios){
                    if(follower.getIdCustomers() == id_customer)  subscribeToTheStudios2.add(follower.getStudios().getCustomers());
            }
            for (CustomersEntity studioEntityForFollowers : subscribeToTheStudios2) {
                imgAndName = "Name: " + studioEntityForFollowers.getName()
                        + "Photo: " + Arrays.toString(studioEntityForFollowers.getImg()) + "   ";
            }
            return imgAndName;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String getForFollowerIMGOfActor() {
        int id_customer = 1;
        String imgAndName = "";
        try {
            List<CustomersEntity> subscribeToTheActors2 = new LinkedList<>();
            List<FollowerActorEntity> subscribeToTheActors = followerActorRepository.findAll();
            for(FollowerActorEntity follower: subscribeToTheActors){
                if(follower.getIdCustomers() == id_customer)  subscribeToTheActors2.add(follower.getActors().getCustomerActor());
            }
            for (CustomersEntity actorEntityForFollowers : subscribeToTheActors2) {
                imgAndName = "Name: " + actorEntityForFollowers.getName()
                        + "Photo: " + Arrays.toString(actorEntityForFollowers.getImg()) + "   ";
            }
            return imgAndName;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String getForFollowerIMGOfAnalyst() {
        int id_customer = 1;
        String imgAndName = "";
        try {
            List<CustomersEntity> subscribeToTheAnalyst2 = new LinkedList<>();
            List<FollowerAnalystEntity> subscribeToTheAnalysts = followerAnalystRepository.findAll();
            for(FollowerAnalystEntity follower: subscribeToTheAnalysts){
                if(follower.getIdCustomers() == id_customer)  subscribeToTheAnalyst2.add(follower.getAnalysts().getCustomersAnalyst());
            }
            for (CustomersEntity actorEntityForFollowers : subscribeToTheAnalyst2) {
                imgAndName = "Name: " + actorEntityForFollowers.getName()
                        + "Photo: " + Arrays.toString(actorEntityForFollowers.getImg()) + "   ";
            }
            return imgAndName;
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
