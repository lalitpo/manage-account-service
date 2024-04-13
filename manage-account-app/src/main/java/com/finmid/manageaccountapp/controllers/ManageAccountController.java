package com.finmid.manageaccountapp.controllers;

import com.finmid.manageaccountapp.model.Account;
import com.finmid.manageaccountapp.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ManageAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserAccount(@RequestBody Account userAccount) {
        try {
            userAccountService.createUserAccount(userAccount);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User account creation failed : " + e.getMessage());
        }
        return ResponseEntity.ok("User account created successfully");
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Object> getAccountBalance(@PathVariable String accountId) {
        try {
            Account accountInfo =  userAccountService.getAccountInfo(accountId);
            return ResponseEntity.ok(accountInfo.getBalance());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User Account balance could not be retrieved : " + e.getMessage());
        }
    }


}
