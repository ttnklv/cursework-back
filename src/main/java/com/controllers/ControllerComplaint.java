package com.controllers;

import com.database.ComplaintEntity;
import com.google.gson.Gson;
import com.service.AdminService;
import com.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerComplaint {


    private final ComplaintService complaintService;

    @Autowired
    public ControllerComplaint(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/answerw")
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


    @RequestMapping(value = "/newComplaint", method = RequestMethod.POST)
    public ResponseEntity addTag(@RequestParam("id") int id,
                                 @RequestParam("body") String body) {
        complaintService.saveNewComplaint(body, id);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/answerForComplaint", method = RequestMethod.POST)
    public ResponseEntity answerForComplaint(@RequestParam("idComplaint") int id,
                                             @RequestParam("body") String body) {
        complaintService.answer(id, body);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/getAllComplaints", method = RequestMethod.GET)
    public ResponseEntity getAllComplaints() {
        Gson g = new Gson();
        StringBuilder builder = new StringBuilder();
        List<ComplaintEntity> complaints = complaintService.currentComplaint();
        builder.append("[");
        for (ComplaintEntity complaint : complaints
        ) {
            builder.append(g.toJson(complaint));
            builder.append(",");
        }
        builder.append("]");
        return ResponseEntity.ok(builder.toString());
    }

}
