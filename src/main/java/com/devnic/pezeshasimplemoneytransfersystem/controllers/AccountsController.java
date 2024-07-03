package com.devnic.pezeshasimplemoneytransfersystem.controllers;

import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerAccountRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.responses.SuccessResponse;
import com.devnic.pezeshasimplemoneytransfersystem.models.CustomerAccounts;
import com.devnic.pezeshasimplemoneytransfersystem.services.implementation.CustomerAccountsManagementServiceImpl;
import com.devnic.pezeshasimplemoneytransfersystem.services.interfaces.CustomerAccountsManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
public class AccountsController {
    private final CustomerAccountsManagementServiceImpl customerAccountsManagementService;

    @PostMapping("/customer")
    private ResponseEntity<SuccessResponse> customerOnboarding(@RequestBody CustomerRequest customerRequest){
        return new ResponseEntity<>(customerAccountsManagementService.onboardCustomer(customerRequest), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SuccessResponse> customerAccountCreation(@RequestBody CustomerAccountRequest accountRequest){
        return  new ResponseEntity<>(customerAccountsManagementService.createCustomerAccount(accountRequest), HttpStatus.OK);
    }

    @GetMapping("{accountId}")
    public ResponseEntity<CustomerAccounts> getCustomerAccountDetailsByUuid(@PathVariable String accountId){
        return new ResponseEntity<>(customerAccountsManagementService.getCustomerAccountInformationById(accountId), HttpStatus.OK);
    }
}
