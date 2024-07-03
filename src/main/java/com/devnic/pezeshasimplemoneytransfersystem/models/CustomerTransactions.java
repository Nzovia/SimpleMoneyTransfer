package com.devnic.pezeshasimplemoneytransfersystem.models;

import com.devnic.pezeshasimplemoneytransfersystem.commons.PO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@Entity
@Table(name = "tb_customer_transactions")
@Getter
@Setter
@NoArgsConstructor
public class CustomerTransactions extends PO {
    private String sourceAccount;
    private String destinationAccount;
    private String sendAmount;
    private LocalDateTime transactionDate;



}
