package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Account;

import java.util.List;

public interface AccountDao
{
    Account getAccountById(int accountId);

    Account getBalanceByUsername(String username);

    List<Account> getAccounts();
}

