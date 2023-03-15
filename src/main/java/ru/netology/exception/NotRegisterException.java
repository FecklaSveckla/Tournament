package ru.netology.exception;

public class NotRegisterException extends RuntimeException {

    public NotRegisterException(String message) {
        super( message );
    }
}