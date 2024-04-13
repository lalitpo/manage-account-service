CREATE TABLE user_accounts (
                               account_id varchar PRIMARY KEY,
                               balance NUMERIC(10, 2)
);
CREATE TABLE transaction_history (
                                     transaction_id varchar PRIMARY KEY,
                                     amount NUMERIC(10, 2),
                                     from_account_id varchar,
                                     to_account_id varchar,
                                     FOREIGN KEY (from_account_id) REFERENCES user_accounts (account_id),
                                     FOREIGN KEY (to_account_id) REFERENCES user_accounts (account_id)
);
