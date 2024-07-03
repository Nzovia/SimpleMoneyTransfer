package com.devnic.pezeshasimplemoneytransfersystem.models;

import com.devnic.pezeshasimplemoneytransfersystem.commons.PO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends PO {
    @Column(name = "customer_name", nullable = false)
    @NotBlank(message = "full name is required")
    private String customerName;
    @Column(name = "customer_email", nullable = false, unique = true)
    @NotBlank(message = "user email is required")
    @Email
    @Size(max = 200)
    private String customerEmail;
    @Column(name = "customer_password")
    @NotBlank(message = "password is required")
    @Size(max = 255)
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerAccounts> orders;

}
