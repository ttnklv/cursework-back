package com.controllers;

import com.service.AnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class ControllerAnalyst {
    private final AnalystService analystService;

    @Autowired
    public ControllerAnalyst(AnalystService analystService) {
        this.analystService = analystService;
    }

    @GetMapping("/allReviewsByAnalystId")
    String allReviewsByAnalystId(){
        TreeMap<String,String> filmRev = analystService.allReviewsByAnalystId(1);
        return String.valueOf(filmRev.firstEntry());
    }

    @GetMapping("/analystInfo")
    String[] analystInfo(){
        return analystService.analystInfo(1);
    }

    @GetMapping("/analystScore")
    public double analystScore()
    {
       return analystService.analystScore(1);
    }

    @GetMapping("/newReview")
    public String add(){
        analystService.addNewReview(2,1,"оооооок");
        return "added";
    }

    @GetMapping("/seconrReview")
    String put(){
        analystService.addNewReview(2,2,"fine");
        return "added";
    }
}
