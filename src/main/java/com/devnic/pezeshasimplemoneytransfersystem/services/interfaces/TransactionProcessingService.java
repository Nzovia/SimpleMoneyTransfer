package com.devnic.pezeshasimplemoneytransfersystem.services.interfaces;

import com.devnic.pezeshasimplemoneytransfersystem.dtos.requests.TransactionRequest;
import com.devnic.pezeshasimplemoneytransfersystem.dtos.responses.SuccessResponse;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public interface TransactionProcessingService {
    SuccessResponse transactionProcessing(TransactionRequest transactionRequest);

}
