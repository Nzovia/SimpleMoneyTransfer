package com.devnic.pezeshasimplemoneytransfersystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
public class CustomerAccountRequest {
    private  String customerAccountNumber;
    private BigDecimal initialAccountBalance;
    private String customerId;
}
