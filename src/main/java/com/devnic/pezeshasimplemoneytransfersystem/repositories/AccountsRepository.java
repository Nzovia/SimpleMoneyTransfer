package com.devnic.pezeshasimplemoneytransfersystem.repositories;

import com.devnic.pezeshasimplemoneytransfersystem.models.CustomerAccounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface AccountsRepository extends JpaRepository<CustomerAccounts,Long> {
    boolean existsByCustomerAccountNumber(String customerAccountNumber);
    Optional<CustomerAccounts> findByUuid(String accountId);

    Optional<CustomerAccounts> findByCustomerAccountNumber(String sourceAccountNumber);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerAccounts a SET a.accountBalance = :accountBalance WHERE a.uuid = :uuid")
    void updateAccountBalance(@Param("uuid") String uuid, @Param("accountBalance") BigDecimal newAccountBalance);
}
