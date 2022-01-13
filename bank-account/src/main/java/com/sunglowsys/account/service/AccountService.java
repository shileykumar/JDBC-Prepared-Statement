package com.sunglowsys.account.service;

import com.sunglowsys.account.domain.Account;

public interface AccountService {
    void openNewAccount(Account account);
    Account getAccountDetails(Account account);
    Double deposit(Account account);
    Double withdraw(Account account);
    Double checkBalance(Account account);

}
