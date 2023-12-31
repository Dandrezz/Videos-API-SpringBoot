package com.videos.main.exception.actor;

public class ActorIdMismatchException extends RuntimeException{

        public ActorIdMismatchException() {
            super();
        }

        public ActorIdMismatchException(String message) {
            super(message);
        }

        public ActorIdMismatchException(String message, Throwable cause) {
            super(message, cause);
        }

        public ActorIdMismatchException(Throwable cause) {
            super(cause);
        }

}
