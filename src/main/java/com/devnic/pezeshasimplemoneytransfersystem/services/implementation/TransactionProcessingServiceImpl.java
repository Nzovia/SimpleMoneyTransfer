package com.devnic.pezeshasimplemoneytransfersystem.services.implementation;

import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.TransactionRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.responses.SuccessResponse;
import com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling.NegativeEvaluationException;
import com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling.NotFoundException;
import com.devnic.pezeshasimplemoneytransfersystem.models.CustomerTransactions;
import com.devnic.pezeshasimplemoneytransfersystem.repositories.AccountsRepository;
import com.devnic.pezeshasimplemoneytransfersystem.repositories.TransactionRepository;
import com.devnic.pezeshasimplemoneytransfersystem.services.interfaces.TransactionProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@RequiredArgsConstructor
public class TransactionProcessingServiceImpl implements TransactionProcessingService {
    private final TransactionRepository transactionRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public SuccessResponse transactionProcessing(TransactionRequest transactionRequest) {
        try{
            //validate Accounts...
            var sourceAccount = accountsRepository.findByCustomerAccountNumber(transactionRequest.getSourceAccountNumber())
                    .orElseThrow(() -> new NotFoundException("Source account invalid"));
            var destinationAccount = accountsRepository.findByCustomerAccountNumber(transactionRequest.getDestinationAccountNumber())
                    .orElseThrow(() -> new NotFoundException("Destination account invalid. Recheck account details"));

            //ensure send amount is greater than zero
            if(transactionRequest.getSendAmount().compareTo(BigDecimal.ZERO) <= 0){
                throw new IllegalArgumentException("Send amount must be greater than zero");
            }

            //Compare Source account balance with sending amount before sending.
            if(sourceAccount.getAccountBalance().compareTo(transactionRequest.getSendAmount()) < 0){
                throw new NegativeEvaluationException("Insufficient funds in your A/C prefund before Transfer");
            }

            var transaction = new CustomerTransactions();
            transaction.setSourceAccount(transaction.getSourceAccount());
            transaction.setDestinationAccount(transaction.getDestinationAccount());
            transaction.setSendAmount(transaction.getSendAmount());
            transaction.setTransactionDate(LocalDateTime.now());

            transactionRepository.save(transaction);

            //Update both SourceAccount and DestinationAccount balance, less source A/C increment Destination A/C
            var newAccountBalance = BigDecimal.ZERO;
            newAccountBalance = sourceAccount.getAccountBalance().subtract(transactionRequest.getSendAmount());
            accountsRepository.updateAccountBalance(sourceAccount.getUuid(), newAccountBalance);

            newAccountBalance = destinationAccount.getAccountBalance().add(transactionRequest.getSendAmount());
            accountsRepository.updateAccountBalance(destinationAccount.getUuid(), newAccountBalance);

            return new SuccessResponse(200,"Transaction Processed Successfully");

        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
