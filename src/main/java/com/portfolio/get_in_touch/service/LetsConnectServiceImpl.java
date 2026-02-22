package com.portfolio.get_in_touch.service;

import com.portfolio.get_in_touch.model.LetsConnect;
import com.portfolio.get_in_touch.repository.GetInTouchRepository;
import com.portfolio.get_in_touch.repository.LetsConnectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetsConnectServiceImpl {

    private final LetsConnectRepository repository;

    public LetsConnectServiceImpl(LetsConnectRepository repository) {
        this.repository = repository;
    }

    public List<LetsConnect> submitDetails(List<LetsConnect> letsConnect){
        return repository.saveAll(letsConnect);
    }

    public List<LetsConnect> getAllVisitors(){
        return repository.findAll();
    }

    public List<LetsConnect> updateAllUserDetails(){
        List<LetsConnect> allUsers = repository.findAll();

        for(LetsConnect lc : allUsers){
            lc.setName("User__" + lc.getName());
            repository.save(lc);
        }

        return allUsers;
    }
}
