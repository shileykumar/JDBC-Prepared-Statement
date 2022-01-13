package com.sunglowsys.account.repository;

import com.sunglowsys.account.db.DbConnection;
import com.sunglowsys.account.domain.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepositoryImpl implements AccountRepository{
    Connection connection = DbConnection.getConnection();
    @Override
    public void openNewAccount(Account account) {

        String sql = "insert into account(account_no, account_type, first_name, last_name, email, mobile, city, balance) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,account.getAccountNo());
            statement.setString(2,account.getAccountType());
            statement.setString(3,account.getFirstName());
            statement.setString(4,account.getLastName());
            statement.setString(5,account.getEmail());
            statement.setString(6,account.getMobile());
            statement.setString(7,account.getCity());
            statement.setDouble(8,account.getBalance());
            int result = statement.executeUpdate();
            if(result > 0){
                System.out.println("created----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccountDetails(Account account) {
        Account account1 = new Account();
        String sql = "select *from account where mobile = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,account.getMobile());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Long id = resultSet.getLong(1);
                Long accountNo = resultSet.getLong(2);
                String accountType = resultSet.getNString(3);
                String firstName = resultSet.getString(4);
                String lastName = resultSet.getString(5);
                String email = resultSet.getString(6);
                String mobile = resultSet.getString(7);
                String city = resultSet.getString(8);
                Double balance = resultSet.getDouble(9);


                account1.setId(id);
                account1.setAccountNo(accountNo);
                account1.setAccountType(accountType);
                account1.setFirstName(firstName);
                account1.setLastName(lastName);
                account1.setEmail(email);
                account1.setMobile(mobile);
                account1.setCity(city);
                account1.setBalance(balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account1;
    }

    @Override
    public Account deposit(Account account) {
        String sql = "update account set balance = ? where account_no = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1,account.getBalance());
            statement.setLong(2,account.getAccountNo());
            int result = statement.executeUpdate();
            if (result > 0){
                System.out.println("deposited---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Double withdraw(Account account) {
        String sql = "update account set balance = ? where account_no = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1,account.getBalance());
            statement.setLong(2,account.getAccountNo());
            int result = statement.executeUpdate();
            if (result > 0){
                System.out.println("withdraw done---");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Double checkBalance(Account account) {
        String sql = "select balance from account where account_no = ?";
        Double balance = 0.0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,account.getAccountNo());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                 balance = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
}
