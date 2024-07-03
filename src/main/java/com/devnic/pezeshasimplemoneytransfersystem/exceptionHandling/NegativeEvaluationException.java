package com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class NegativeEvaluationException extends RuntimeException{
    public NegativeEvaluationException(String message) {
        super(message);
    }
}
