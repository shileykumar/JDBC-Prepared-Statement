package com.sunglowsys.account.repository;

import com.sunglowsys.account.domain.Account;

public interface AccountRepository {
    void openNewAccount(Account account);
    Account getAccountDetails(Account account);
    Account deposit(Account account);
    Double withdraw(Account account);
    Double checkBalance(Account account);
}
