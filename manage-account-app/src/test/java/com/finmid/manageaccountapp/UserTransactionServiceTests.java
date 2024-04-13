package com.finmid.manageaccountapp;

import com.finmid.manageaccountapp.model.Account;
import com.finmid.manageaccountapp.model.Transaction;
import com.finmid.manageaccountapp.repository.UserAccountRepository;
import com.finmid.manageaccountapp.repository.UserTransactionRepository;
import com.finmid.manageaccountapp.service.UserAccountService;
import com.finmid.manageaccountapp.service.UserTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserTransactionServiceTests {
    private final Transaction transaction1 = new Transaction("t1", 23.2, "abc1", "abc2");

    private final Transaction transaction2 = new Transaction("t1", -10.2, "abc2", "abc1");

    private final Transaction transaction3 = new Transaction("t1", 10.2, "abc2", "abc1");

    private final Account userMock1 = new Account("abc1", 80.92);

    private final Account userMock2 = new Account("abc2", 5.3);
    @Mock
    private UserAccountRepository userAccountRepositoryMock;
    @InjectMocks
    private UserTransactionService userTransactionServiceMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenTransferAmountIsNegativeThenThrowException() {
        assertThrows(Exception.class, () -> userTransactionServiceMock.createTransaction(transaction2));
    }

    @Test
    void whenAnyUserDoesNotExistsThenThrowException() {

        when(userAccountRepositoryMock.findById(transaction1.getFromAccountId())).thenReturn(Optional.empty());
        when(userAccountRepositoryMock.findById(transaction1.getToAccountId())).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> userTransactionServiceMock.createTransaction(transaction1));

    }

    @Test
    void whenSenderBalanceIsLessThanTransferAmountThenThrowsException() {

        when(userAccountRepositoryMock.findById(transaction3.getFromAccountId())).thenReturn(Optional.of(userMock2));
        when(userAccountRepositoryMock.findById(transaction3.getToAccountId())).thenReturn(Optional.of(userMock1));

        assertThrows(Exception.class, () -> userTransactionServiceMock.createTransaction(transaction3));
    }
}
