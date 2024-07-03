package com.devnic.pezeshasimplemoneytransfersystem.services.implementation;

import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerAccountRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.responses.SuccessResponse;
import com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling.NotFoundException;
import com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling.ResourceTakenException;
import com.devnic.pezeshasimplemoneytransfersystem.models.Customer;
import com.devnic.pezeshasimplemoneytransfersystem.models.CustomerAccounts;
import com.devnic.pezeshasimplemoneytransfersystem.repositories.AccountsRepository;
import com.devnic.pezeshasimplemoneytransfersystem.repositories.CustomerRepository;
import com.devnic.pezeshasimplemoneytransfersystem.services.interfaces.CustomerAccountsManagementService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@RequiredArgsConstructor
public class CustomerAccountsManagementServiceImpl implements CustomerAccountsManagementService {
    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public SuccessResponse onboardCustomer(CustomerRequest customerRequest) {

        try{
            var emailExists = customerRepository.existsByCustomerEmail(customerRequest.getCustomerEmail());
            if(emailExists){
                throw new ResourceTakenException("Email already exists");
            }
            Customer onBoardedCustomer = new Customer();
            onBoardedCustomer.setCustomerName(customerRequest.getCustomerName());
            onBoardedCustomer.setCustomerEmail(customerRequest.getCustomerEmail());

            //TODO. on adding spring security i will utilize ByCrypt encoder to Hash Passwords
            onBoardedCustomer.setPassword(customerRequest.getPassword());

            //saving customer to the database
            customerRepository.save(onBoardedCustomer);
            return new SuccessResponse(200,"Customer OnBoarded Created");
        }catch (Exception e){
            throw new ResourceTakenException(e.getMessage());

        }
    }

    @Override
    public SuccessResponse createCustomerAccount(CustomerAccountRequest customerAccountRequest) {
        try {
            var accountExists = accountsRepository
                    .existsByCustomerAccountNumber(customerAccountRequest.getCustomerAccountNumber());
            if (accountExists) {
                throw new ResourceTakenException("account number taken");
            }

            //Getting Account Holder.
            Customer customer = customerRepository.findByUuid(customerAccountRequest.getCustomerId())
                    .orElseThrow(() ->
                            new RuntimeException("Customer not found with ID: " + customerAccountRequest.getCustomerId()));

            CustomerAccounts customerAccounts = new CustomerAccounts();
            customerAccounts.setCustomer(customer);
            customerAccounts.setCustomerAccountNumber(customerAccountRequest.getCustomerAccountNumber());
            customerAccounts.setAccountBalance(customerAccountRequest.getInitialAccountBalance());

            accountsRepository.save(customerAccounts);
            return new SuccessResponse(200,"Customer Account Created");
        }catch (Exception e){
            throw new ResourceTakenException(e.getMessage());
        }
    }
    @Override
    public CustomerAccounts getCustomerAccountInformationById(String accountId) {
        try {
            val customerAccountDetails = accountsRepository.findByUuid(accountId)
                    .orElseThrow(() ->
                            new NotFoundException("Account with ID: " + accountId +" not found "));;


            return customerAccountDetails;

        }catch (Exception exception){
            throw new NotFoundException(exception.getMessage());
        }
    }
}
