package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@RequestMapping ("/account")
public class AccountController
{
    private AccountDao accountDao;

    public AccountController(AccountDao accountDao)
    {
        this.accountDao = accountDao;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="", method=RequestMethod.POST)
    public Account createAccount(@RequestBody Account account)
    {
        return accountDao.createMyAccount(account);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="", method=RequestMethod.GET)
    public Account showMyAccount(@PathVariable int userId)
    {
        return accountDao.showMyAccount(userId);
    }


}
