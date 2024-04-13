package com.finmid.manageaccountapp.controllers;

import com.finmid.manageaccountapp.model.Transaction;
import com.finmid.manageaccountapp.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class ManageTransactionController{

    @Autowired
    private UserTransactionService userTransactionService;

    @PostMapping("/createTransaction")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transactionRequest) {
        try {
            userTransactionService.createTransaction(transactionRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Transaction failed : " + e.getMessage());
        }
        return ResponseEntity.ok("Transaction was successful.");
    }

}
