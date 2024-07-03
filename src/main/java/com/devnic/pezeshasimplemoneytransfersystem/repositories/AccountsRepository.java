package com.devnic.pezeshasimplemoneytransfersystem.repositories;

import com.devnic.pezeshasimplemoneytransfersystem.models.CustomerAccounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public interface AccountsRepository extends JpaRepository<CustomerAccounts,Long> {
    boolean existsByCustomerAccountNumber(String customerAccountNumber);
    Optional<CustomerAccounts> findByUuid(String accountId);
}
