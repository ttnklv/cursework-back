package com.controllers;

import com.database.VotesUserEntity;
import com.service.VotesService;
import com.service.VotesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerVotes {

    private final VotesService votesService;
    private final VotesUserService votesUserService;

    @Autowired
    public ControllerVotes(VotesService votesService, VotesUserService votesUserService) {
        this.votesService = votesService;
        this.votesUserService = votesUserService;
    }

    @GetMapping("/createNewVote")
    String createNewVote() {
        String newVote = votesService.addNewVote();
        if (newVote != null)
            return newVote;
        else return "Empty request";
    }

    @GetMapping("/accessVote")
    String accessVote() {
        String vote = votesService.findAllAccessVote();
        if (vote != null)
            return vote;
        else return "Empty request";
    }

    @GetMapping("/checkUserVote")
    String checkUserVote() {
        if (votesUserService.checkUserVote())
            return "Already voted";
        if (votesService.recalculation() == null) return "Cannot add voice";
        return "User can vote, already added answer in votes";
    }

    @GetMapping("/findAllVotesForFilm")
    String findAllVotesForFilm() {
        String answer = votesService.findAllVotesForFilm();
        if (answer == null) return "Cannot find votes for this film";
        return answer;
    }

    @GetMapping("/getInfoForVote")
    String getInfoForVote() {
        String answer = votesService.findInfoForVote();
        if (answer == null) return "Cannot find votes for this film";
        return answer;
    }

}
