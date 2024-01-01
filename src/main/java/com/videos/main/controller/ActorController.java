package com.videos.main.controller;

import com.videos.main.exception.actor.ActorIdMismatchException;
import com.videos.main.exception.actor.ActorNotFoundException;
import com.videos.main.model.Actor;
import com.videos.main.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping
    public Iterable findAll(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    @GetMapping("/name/{actorName}")
    public List findByName(@PathVariable String actorName){
        return actorRepository.findByName(actorName);
    }

    @GetMapping("/{id}")
    public Actor findOne(@PathVariable Long id) {
        return actorRepository.findById(id)
                .orElseThrow(ActorNotFoundException::new);
    }

    @PostMapping
    public Actor create(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        actorRepository.findById(id)
                .orElseThrow(ActorNotFoundException::new);
        actorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@RequestBody Actor actor, @PathVariable Long id){
        if(!actor.getId().equals(id)){
            throw new ActorIdMismatchException();
        }
        actorRepository.findById(id)
                .orElseThrow(ActorNotFoundException::new);
        return actorRepository.save(actor);
    }

}
