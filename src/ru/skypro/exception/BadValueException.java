package ru.skypro.exception;

public class BadValueException extends RuntimeException{
    public BadValueException(String message) {
        super(message);
    }
}
