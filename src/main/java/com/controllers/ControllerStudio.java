package com.controllers;

import com.repository.StudioRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStudio {
    private final StudioRpository studioRpository;

    @Autowired
    public ControllerStudio(StudioRpository studioRpository) {
        this.studioRpository = studioRpository;
    }
}
