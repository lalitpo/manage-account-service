package com.finmid.manageaccountapp;

import com.finmid.manageaccountapp.model.Account;
import com.finmid.manageaccountapp.repository.UserAccountRepository;
import com.finmid.manageaccountapp.service.UserAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserAccountServiceTest {

    private final Account userMock1 = new Account("abc1", 80.92);

    private final Account userMock2 = new Account("abc2", 5.3);
    @Mock
    private UserAccountRepository userAccountRepositoryMock;
    @InjectMocks
    private UserAccountService userAccountServiceMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenUserDoesNotExistThenCreatesUser() throws Exception {

        when(userAccountRepositoryMock.findById(userMock1.getAccountId())).thenReturn(Optional.empty());

        userAccountServiceMock.createUserAccount(userMock1);

        verify(userAccountRepositoryMock, times(1)).save(userMock1);
    }

    @Test
    void whenUserExistsThrowException() {

        when(userAccountRepositoryMock.findById(userMock1.getAccountId())).thenReturn(Optional.of(userMock1));

        assertThrows(Exception.class, () -> userAccountServiceMock.createUserAccount(userMock1));
    }

    @Test
    void whenUserDoesNotExistAndBalanceIsRequestedThenThrowException() {

        when(userAccountRepositoryMock.findById(userMock1.getAccountId())).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> userAccountServiceMock.getAccountInfo(userMock1.getAccountId()));

    }
}
