package com.example.service;

import com.example.http.HttpNames;
import com.example.model.Name;
import com.example.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {

    @Autowired
    private NameRepository  nameRepository = new NameRepository();
    @Autowired
    private HttpNames httpNames = new HttpNames();

    public List<Name> getName(String origin){
        return httpNames.getNames(httpNames.getHtmlNamesPage(origin));
    }

}
