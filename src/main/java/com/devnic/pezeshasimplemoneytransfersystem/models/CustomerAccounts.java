package com.devnic.pezeshasimplemoneytransfersystem.models;

import com.devnic.pezeshasimplemoneytransfersystem.commons.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
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
public class CustomerAccounts extends BaseEntity {
    @Column(nullable = false, unique = true)
    private  String customerAccountNumber;
    @DecimalMin(value = "0.00", message = "Account balance cannot be negative")
    @Column(nullable = false)
    private BigDecimal accountBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_uuid", referencedColumnName  = "uuid")
    private Customer customer;



}
