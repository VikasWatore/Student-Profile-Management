package com.dailycodework.demo.exception;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String s) {
        super(s);
    }
}
