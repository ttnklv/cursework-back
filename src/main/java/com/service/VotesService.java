package com.service;

import com.database.VotesEntity;
import com.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VotesService {

    private final VotesRepository votesRepository;

    @Autowired
    public VotesService(VotesRepository votesRepository) {
        this.votesRepository = votesRepository;
    }

    public String addNewVote() {
        byte[] img = new byte[]{1, 2, 3};
        try {
            VotesEntity votesEntity = new VotesEntity();
            votesEntity.setIdFilm(1);
            votesEntity.setCountNegative(0);
            votesEntity.setCountPositive(0);
            votesEntity.setName("djn");
            votesEntity.setFlagAccess(true);
            votesRepository.save(votesEntity);
            return "Create new Vote";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    private boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public String findAllAccessVote() {
        try {
            StringBuilder votes = new StringBuilder();
            List<VotesEntity> entities = votesRepository.findAllByFlagAccess(true);
            for (VotesEntity entity : entities) {
                votes.append("name: ").append(entity.getName());
            }
            return String.valueOf(votes);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    private void positive(VotesEntity votesEntity) {
        try {
            setFlag(true);
            votesRepository.updatePositive(votesEntity.getCountPositive() + 1, 1);
        } catch (NullPointerException ex) {
            setFlag(false);
        }
    }

    private void negative(VotesEntity votesEntity) {
        try {
            setFlag(true);
            votesRepository.updateNegative(votesEntity.getCountNegative() + 1, 1);
        } catch (NullPointerException ex) {
            setFlag(false);
        }
    }

    public String recalculation() {
        boolean choice = true;
        try {
            VotesEntity votesEntity = votesRepository.findById(1);
            if (choice) positive(votesEntity);
            else negative(votesEntity);
            return "пересчитано";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findAllVotesForFilm() {
        try {
            List<VotesEntity> entities = votesRepository.findAllByIdFilm(1);
            StringBuilder answer = new StringBuilder();
            for (VotesEntity entity : entities) {
                answer.append("Name: ").append(entity.getName())
                        .append("Negative: ").append(entity.getCountNegative())
                        .append("Positive: ").append(entity.getCountPositive())
                        .append("IMG: ").append(Arrays.toString(entity.getVotesImageUrl()));
            }
            return String.valueOf(answer);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findInfoForVote() {
        try {
            int id_vote = 1;
            VotesEntity votesEntity = votesRepository.findById(id_vote);
            return "  Name:  " + votesEntity.getName() + "  Pos: "
                    + votesEntity.getCountPositive() + "  Neg:  " + votesEntity.getCountNegative();
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
