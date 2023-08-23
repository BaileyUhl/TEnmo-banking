package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping ("/account")
public class AccountController
{
    private AccountDao accountDao;

    public AccountController(AccountDao accountDao)
    {this.accountDao = accountDao;}

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public Account showMyAccount(@PathVariable int id)
    {
        return accountDao.getAccountById(id);
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public Account getBalance(Principal principal) {
        return accountDao.getBalanceByUsername(principal.getName());
        }
}
