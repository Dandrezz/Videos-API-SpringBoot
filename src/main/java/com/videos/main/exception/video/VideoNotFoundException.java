package com.videos.main.exception.video;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VideoNotFoundException extends RuntimeException {

    public VideoNotFoundException() {
        super();
    }

    public VideoNotFoundException(String message) {
        super(message);
    }

    public VideoNotFoundException(String message, Throwable cause) {
         super(message, cause);
     }

    public VideoNotFoundException(Throwable cause) {
        super(cause);
    }

}
