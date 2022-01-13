package com.sunglowsys.account.service;

import com.sunglowsys.account.domain.Account;
import com.sunglowsys.account.repository.AccountRepository;
import com.sunglowsys.account.repository.AccountRepositoryImpl;

import java.time.LocalDateTime;

public class AccountServiceImpl implements AccountService{
    AccountRepository repository = new AccountRepositoryImpl();
    @Override
    public void openNewAccount(Account account) {
        int year = LocalDateTime.now().getSecond();
        String accountNo = account.getMobile()+String.valueOf(year);
        account.setAccountNo(Long.parseLong(accountNo));

        repository.openNewAccount(account);
    }

    @Override
    public Account getAccountDetails(Account account) {
        Account account1 = new AccountRepositoryImpl().getAccountDetails(account);
        return account1;
    }

    @Override
    public Double deposit(Account account) {
        account.setBalance(account.getBalance()+repository.checkBalance(account));
        account.setAccountNo(account.getAccountNo());
        repository.deposit(account);
        System.out.print("New Balance is:");
        return repository.checkBalance(account);
    }

    @Override
    public Double withdraw(Account account) {
        account.setBalance(repository.checkBalance(account)-account.getBalance());
        account.setAccountNo(account.getAccountNo());
        repository.withdraw(account);
        System.out.print("Available balance is:");
        return repository.checkBalance(account);
    }

    @Override
    public Double checkBalance(Account account) {
        Double balance = repository.checkBalance(account);

        return balance;
    }


}
