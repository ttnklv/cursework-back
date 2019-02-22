package com.service;

import com.database.VotesUserEntity;
import com.repository.VotesUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotesUserService {

    private final VotesUserRepository votesUserRepository;

    @Autowired
    public VotesUserService(VotesUserRepository votesUserRepository) {
        this.votesUserRepository = votesUserRepository;
    }

    public String addNewVote() {
        try {
            VotesUserEntity votesUserEntity = new VotesUserEntity();
            votesUserEntity.setIdUser(1);
            votesUserEntity.setIdVotes(1);
            votesUserRepository.save(votesUserEntity);
            return "Save person after voting";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public boolean checkUserVote() {
        VotesUserEntity votesUserEntity = votesUserRepository.findByIdUserAndAndIdVotes(1, 1);
        return votesUserEntity != null;
    }

}
