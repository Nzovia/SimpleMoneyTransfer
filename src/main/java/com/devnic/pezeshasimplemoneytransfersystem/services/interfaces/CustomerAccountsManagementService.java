package com.devnic.pezeshasimplemoneytransfersystem.services.interfaces;

import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerAccountRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.responses.SuccessResponse;
import com.devnic.pezeshasimplemoneytransfersystem.models.CustomerAccounts;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface CustomerAccountsManagementService {
    SuccessResponse onboardCustomer(CustomerRequest customerRequest);
    SuccessResponse createCustomerAccount(CustomerAccountRequest customerAccountRequest);
    CustomerAccounts getCustomerAccountInformationById(String accountId);

}
