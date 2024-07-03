package com.devnic.pezeshasimplemoneytransfersystem.repositories;

import com.devnic.pezeshasimplemoneytransfersystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCustomerEmail(String customerEmail);

    Optional<Customer> findByUuid(String customerId);
}
