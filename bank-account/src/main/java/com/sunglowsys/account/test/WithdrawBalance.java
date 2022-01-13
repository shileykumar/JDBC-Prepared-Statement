package com.sunglowsys.account.test;

import com.sunglowsys.account.domain.Account;
import com.sunglowsys.account.service.AccountServiceImpl;

public class WithdrawBalance {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNo(97205565332022L);
        account.setBalance(500.0);
        System.out.println(new AccountServiceImpl().withdraw(account));
    }
}
