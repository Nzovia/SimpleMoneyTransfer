package com.devnic.pezeshasimplemoneytransfersystem.controllers;

import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.CustomerRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.TransactionRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.responses.SuccessResponse;
import com.devnic.pezeshasimplemoneytransfersystem.services.interfaces.TransactionProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/transfers")
@RequiredArgsConstructor
public class TransactionsController {
    private final TransactionProcessingService transactionProcessingService;
    @PostMapping
    private ResponseEntity<SuccessResponse> customerOnboarding(
            @RequestBody TransactionRequest transactionRequest){
        return new ResponseEntity<>(transactionProcessingService
                .transactionProcessing(transactionRequest), HttpStatus.OK);
    }
}
