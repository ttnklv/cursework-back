package com.controllers;

import com.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScore {

    private final ScoreService scoreService;

    @Autowired
    public ControllerScore(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/getScoreAnalyst")
    String getScoreAnalyst() {
        String answer = scoreService.findAllScoreForAnalyst();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/getScoreActor")
    String getScoreActor() {
        String answer = scoreService.findAllScoreForActor();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/getScoreStudio")
    String getScoreStudio() {
        String answer = scoreService.findAllScoreForStudio();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/getScoreFilm")
    String getScoreFilm() {
        String answer = scoreService.findAllScoreForFilm();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/setScoreAnalyst")
    String setScoreAnalyst() {
        String answer = scoreService.insertNewScoreForAnalyst();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

}
