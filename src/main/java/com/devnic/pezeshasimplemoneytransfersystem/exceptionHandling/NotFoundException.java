package com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
