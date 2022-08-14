package com.example.controller;

import com.example.model.Origin;
import com.example.service.OriginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/origin")
public class OriginController {

    private OriginService originService = new OriginService();

    @GetMapping("")
    public List<Origin> getOrigin(){
        return originService.getOrigin();
    }
}
