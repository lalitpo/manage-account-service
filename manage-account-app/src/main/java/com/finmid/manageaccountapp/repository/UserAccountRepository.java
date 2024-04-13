package com.finmid.manageaccountapp.repository;

import com.finmid.manageaccountapp.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<Account, String> {
}
