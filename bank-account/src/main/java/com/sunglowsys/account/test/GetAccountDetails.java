package com.sunglowsys.account.test;

import com.sunglowsys.account.domain.Account;
import com.sunglowsys.account.service.AccountServiceImpl;

public class GetAccountDetails {
    public static void main(String[] args) {
        Account account = new Account();
        account.setMobile("9758660682");
        System.out.println(new AccountServiceImpl().getAccountDetails(account));
    }
}
