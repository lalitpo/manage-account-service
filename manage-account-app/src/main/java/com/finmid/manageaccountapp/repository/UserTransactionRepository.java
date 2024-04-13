package com.finmid.manageaccountapp.repository;

import com.finmid.manageaccountapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends CrudRepository<Transaction, String> {
}
