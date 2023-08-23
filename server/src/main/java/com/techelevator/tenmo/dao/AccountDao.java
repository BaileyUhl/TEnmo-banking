package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Account;

public interface AccountDao
{
    Account showMyAccount(int accountId);
    Account createMyAccount(Account account);
}

