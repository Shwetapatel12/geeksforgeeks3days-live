package org.geeksforgeeks.crash_course_spring.exceptionhandling;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}