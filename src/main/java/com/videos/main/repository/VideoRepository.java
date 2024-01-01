package com.videos.main.repository;

import com.videos.main.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Page<Video> findAll(Pageable pageable);

    List<Video> findByTitle(String title);

    List<Video> findByTitleContainingIgnoreCase(String title);

}
