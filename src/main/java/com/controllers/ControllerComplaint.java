package com.controllers;

import com.service.AdminService;
import com.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerComplaint {


    private final ComplaintService complaintService;

    @Autowired
    public ControllerComplaint(ComplaintService complaintService) {
        this.complaintService = complaintService; }

    @GetMapping("/answer")
    String getAns() {
        String answer = complaintService.returnAnswers();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

    @GetMapping("/allComplains")
    String getComplains() {
        String answer = complaintService.returnAllComplaintForDevelopers();
        if (answer != null)
            return answer;
        else return "Empty request";
    }


    @GetMapping("/saveComplain")
    String saveComplains() {
        String answer = complaintService.saveNewComplaint();
        if (answer != null)
            return answer;
        else return "Empty request";
    }
}
