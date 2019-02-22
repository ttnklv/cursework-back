package com.controllers;

import com.repository.TransactionRepository;
import com.service.AdminService;
import com.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerSystem {

    private final SystemService systemService;

    @Autowired
    public ControllerSystem(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/info")
    String info() {
        String info = systemService.returnInfo();
        if (info != null)
            return info;
        else return "Empty request";
    }

    @GetMapping("/money")
    String money() {
        String answer = systemService.moneyTransfer();
        if (answer != null)
            return answer;
        else return "Empty request";
    }

}