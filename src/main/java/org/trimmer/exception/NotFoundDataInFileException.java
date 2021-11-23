package org.trimmer.exception;

public class NotFoundDataInFileException extends RuntimeException {

    private final String message;

    public NotFoundDataInFileException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
