package com.videos.main.exception.video;

public class VideoIdMismatchException extends RuntimeException{

        public VideoIdMismatchException() {
            super();
        }

        public VideoIdMismatchException(String message) {
            super(message);
        }

        public VideoIdMismatchException(String message, Throwable cause) {
            super(message, cause);
        }

        public VideoIdMismatchException(Throwable cause) {
            super(cause);
        }

}
