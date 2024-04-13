package com.finmid.manageaccountapp.service;

import com.finmid.manageaccountapp.model.Account;
import com.finmid.manageaccountapp.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public void createUserAccount(Account user) throws Exception {
        if (userAccountRepository.findById(user.getAccountId()).isPresent()) {
            throw new Exception("User with " + user.getAccountId() + " already exists");
        }
        if (user.getBalance() < 0) {
            throw new Exception("User with negative balance cannot be created.");
        }
        userAccountRepository.save(user);
    }

    public Account getAccountInfo(String accountId) throws Exception {
        Optional<Account> accountInfo = userAccountRepository.findById(accountId);
        if (accountInfo.isPresent()) {
            return accountInfo.get();
        } else {
            throw new Exception("Account " + accountId + " not found.");
        }
    }
}
