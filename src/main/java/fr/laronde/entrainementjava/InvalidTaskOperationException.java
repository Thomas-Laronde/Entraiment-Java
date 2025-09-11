package fr.laronde.entrainementjava;

public class InvalidTaskOperationException extends RuntimeException {
    public InvalidTaskOperationException(String message) {
        super(message);
    }
}
