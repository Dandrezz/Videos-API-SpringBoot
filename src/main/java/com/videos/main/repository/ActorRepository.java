package com.videos.main.repository;

import com.videos.main.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Page<Actor> findAll(Pageable pageable);

    List<Actor> findByName(String name);

}
