package com.videos.main.exception.actor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ActorNotFoundException extends RuntimeException{

    public ActorNotFoundException() {
        super();
    }

    public ActorNotFoundException(String message) {
        super(message);
    }

    public ActorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActorNotFoundException(Throwable cause) {
        super(cause);
    }

}
