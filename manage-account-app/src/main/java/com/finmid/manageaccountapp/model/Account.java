package com.finmid.manageaccountapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_accounts")
@Entity
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;
    private double balance;
}
