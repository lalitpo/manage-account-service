package com.finmid.manageaccountapp.service;

import com.finmid.manageaccountapp.model.Account;
import com.finmid.manageaccountapp.model.Transaction;
import com.finmid.manageaccountapp.processor.UserTransactionProcessor;
import com.finmid.manageaccountapp.repository.UserAccountRepository;
import com.finmid.manageaccountapp.repository.UserTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTransactionService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    @Autowired
    private UserTransactionProcessor userTransactionProcessor;

    public void createTransaction(Transaction transactionRequest) {
        Optional<Account> senderAccountInfo = userAccountRepository.findById(transactionRequest.getFromAccountId());
        Optional<Account> receiverAccountInfo = userAccountRepository.findById(transactionRequest.getToAccountId());

        if (senderAccountInfo.isEmpty()) {
            throw new IllegalArgumentException("Sender account does not exist.");
        }
        if (receiverAccountInfo.isEmpty()) {
            throw new IllegalArgumentException("Receiver account does not exist.");
        }

        Account senderAccount = senderAccountInfo.get();
        Account receiverAccount = receiverAccountInfo.get();

        validateUser(transactionRequest);

        userTransactionProcessor.executeTransaction(transactionRequest, senderAccount, receiverAccount);
        userTransactionRepository.save(transactionRequest);
    }

    private void validateUser(Transaction transaction) {
        String senderId = transaction.getFromAccountId();
        String receiverId = transaction.getToAccountId();

        if (senderId.equals(receiverId)) {
            throw new IllegalArgumentException("Users cannot send money to themselves.");
        }
    }
}
