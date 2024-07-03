package com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponseBody {
    private String message;
    private String errorCause;

    public ExceptionResponseBody(String message, Throwable cause) {
        this.message = message;
        this.errorCause = String.valueOf(cause);
    }
}
