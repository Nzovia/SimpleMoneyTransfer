package com.devnic.pezeshasimplemoneytransfersystem.dtos.responses;

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
public class SuccessResponse {
    private int status;
    private String successMessage;
}
