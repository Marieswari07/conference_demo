package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public session create(@RequestBody final session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
    // Also need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value ="{id}",method = RequestMethod.PUT)
    public session update(@PathVariable Long id, @RequestBody session session){
        session existingSession=sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
