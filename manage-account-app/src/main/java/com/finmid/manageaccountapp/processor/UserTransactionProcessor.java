package com.finmid.manageaccountapp.processor;

import com.finmid.manageaccountapp.model.Account;
import com.finmid.manageaccountapp.model.Transaction;
import com.finmid.manageaccountapp.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class UserTransactionProcessor {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private final Lock transferLock = new ReentrantLock();

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = { SQLException.class })
    public void executeTransaction(Transaction transactionRequest, Account senderAccount, Account receiverAccount) {
        if (transferLock.tryLock()) {
            try {
                validateBalance(senderAccount, transactionRequest.getAmount());
                senderAccount.setBalance(senderAccount.getBalance() - transactionRequest.getAmount());
                receiverAccount.setBalance(receiverAccount.getBalance() + transactionRequest.getAmount());

                userAccountRepository.saveAll(Arrays.asList(senderAccount, receiverAccount));
            } finally {
                transferLock.unlock();
            }
        } else {
            throw new IllegalStateException("Unable to acquire lock for executing transaction.");
        }
    }

    private void validateBalance(Account senderAccountInfo, double amount) {
        if (senderAccountInfo.getBalance() < amount) {
            throw new IllegalArgumentException(senderAccountInfo.getAccountId() + " has insufficient balance.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Transfer amount cannot be negative.");
        }
    }
}
