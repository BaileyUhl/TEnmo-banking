package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AccountDTO;
import com.techelevator.tenmo.model.UserDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcAccountDaoTests extends BaseDaoTests
{

private static final Account ACCOUNT_1 = new Account(100, 1001, 2001);
private static final Account ACCOUNT_2 = new Account(1000, 1002, 2002);
private static final AccountDTO ACCOUNT_DTO = new AccountDTO("user", 100);
private JdbcAccountDao sut;
private Account testAccount;
    @Before
    public void setup()
    {
        sut = new JdbcAccountDao(dataSource);
        testAccount = new Account(5, 5, 5);
    }

    @Test
    public void getAccountById_returns_correct_account()
    {
            Account account = sut.getAccountById(2001);
            assertAccountsMatch(ACCOUNT_1, account);

            account = sut.getAccountById(2002);
            assertAccountsMatch(ACCOUNT_2, account);
    }


    @Test
    public void findAllAccounts()
    {
        List<Account> accounts = sut.getAccounts();
        Assert.assertEquals(1, accounts.size());
    }



    @Test
    public void getAccountById_returns_null_when_id_not_found()
    {
            Account account = sut.getAccountById(99);
            Assert.assertNull(account);
    }

    private void assertAccountsMatch(Account expected, Account actual)
    {
            Assert.assertEquals(expected.getBalance(), actual.getBalance(), 0.0);
            Assert.assertEquals(expected.getUserId(), actual.getUserId());
            Assert.assertEquals(expected.getAccountId(), actual.getAccountId());
    }

}
