package com.example.service;

import com.example.http.HttpOrigin;
import com.example.model.Origin;
import com.example.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService {

    @Autowired
    private OriginRepository originRepository = new OriginRepository();

    private HttpOrigin httpOrigin = new HttpOrigin();

    public List<Origin> getOrigin(){
        return httpOrigin.getOrigin(httpOrigin.getHtmlPageOrigin());
    }
}
