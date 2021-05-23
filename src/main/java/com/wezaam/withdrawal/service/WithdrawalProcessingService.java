package com.wezaam.withdrawal.service;

import org.springframework.stereotype.Component;

import com.wezaam.withdrawal.exception.TransactionException;
import com.wezaam.withdrawal.model.PaymentMethod;

@Component
public class WithdrawalProcessingService {

    public Long sendToProcessing(double amount, PaymentMethod paymentMethod) throws TransactionException {
        // call a payment provider
        // in case a transaction can be process
        // it generates a transactionId and process the transaction async
        // otherwise it throws TransactionException
        return System.nanoTime();
    }
}
