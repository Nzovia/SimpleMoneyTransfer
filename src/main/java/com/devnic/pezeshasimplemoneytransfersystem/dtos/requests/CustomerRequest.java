package com.devnic.pezeshasimplemoneytransfersystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
public class CustomerRequest {
    private String customerName;
    private String customerEmail;
    private String password;

}
