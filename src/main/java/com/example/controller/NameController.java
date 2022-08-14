package com.example.controller;

import com.example.model.Name;
import com.example.model.Origin;
import com.example.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    @Autowired
    private NameService nameService = new NameService();

    @GetMapping("/{origin}")
    public List<Name> getName(@PathVariable String origin){
        return nameService.getName(origin);
    }

}
