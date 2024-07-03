package com.devnic.pezeshasimplemoneytransfersystem.models;

import com.devnic.pezeshasimplemoneytransfersystem.commons.PO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_customer_accounts")
@Getter
@Setter
@NoArgsConstructor
public class CustomerAccounts extends PO {
    private  String customerAccountNumber;
    private BigDecimal accountBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;



}
