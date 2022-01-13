package com.sunglowsys.account.test;

import com.sunglowsys.account.domain.Account;
import com.sunglowsys.account.service.AccountServiceImpl;

public class OpenAccount {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountType("Saving");
        account.setFirstName("Pravedra");
        account.setLastName("kumar");
        account.setEmail("pk@gmail.com");
        account.setMobile("97586606");
        account.setCity("Bangalore");
        account.setBalance(100.00);

        new AccountServiceImpl().openNewAccount(account);
    }
}
