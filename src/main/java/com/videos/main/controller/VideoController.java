package com.videos.main.controller;

import com.videos.main.exception.video.VideoIdMismatchException;
import com.videos.main.exception.video.VideoNotFoundException;
import com.videos.main.model.Video;
import com.videos.main.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public Iterable findAll(Pageable pageable) {
        return videoRepository.findAll(pageable);
    }

    @GetMapping("/title/{videoTitle}")
    public List findByTitle(@PathVariable String videoTitle){
        return videoRepository.findByTitle(videoTitle);
    }

    @GetMapping("/title/search")
    public List<Video> searchVideos(@RequestParam String title) {
        return videoRepository.findByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/{id}")
    public Video findOne(@PathVariable Long id) {
        return videoRepository.findById(id)
                .orElseThrow(VideoNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Video create(@RequestBody Video video) {
        return videoRepository.save(video);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        videoRepository.findById(id)
                .orElseThrow(VideoNotFoundException::new);
        videoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Video updateVideo(@RequestBody Video video, @PathVariable Long id){
        if(video.getId() != id){
            throw new VideoIdMismatchException();
        }
        videoRepository.findById(id)
                .orElseThrow(VideoNotFoundException::new);
        return videoRepository.save(video);
    }

}
