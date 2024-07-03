package com.devnic.pezeshasimplemoneytransfersystem.models;

import com.devnic.pezeshasimplemoneytransfersystem.commons.PO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String senderUUid;
    private String recipientUUid;
    private String sendAmount;
    private String transactionDate;


}
