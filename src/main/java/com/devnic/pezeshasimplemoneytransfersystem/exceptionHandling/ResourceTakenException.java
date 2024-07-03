package com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling;

/**
 * @author Nicholas Nzovia
 * @On 15/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class ResourceTakenException extends RuntimeException{
    public ResourceTakenException(String message) {
        super(message);
    }
}
