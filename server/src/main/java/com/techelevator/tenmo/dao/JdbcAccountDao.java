package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.NoSuchElementException;


public class JdbcAccountDao implements AccountDao
{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account showMyAccount(int accountId)
    {
        Account account = null;
        String sql = "SELECT account_id FROM account WHERE account_id = ?;";

        try
        {
            SqlRowSet accountResult = jdbcTemplate.queryForRowSet(sql, accountId);

            if (accountResult.next())
            {
                account = mapRowToAccount(accountResult);
            }
        }
        catch (NoSuchElementException e)
        {
            throw new DaoException("That Account Id doesn't exist", e);
        }
        return account;
    }






    @Override
    public Account createMyAccount(Account account)
    {
        return null;
    }




    private Account mapRowToAccount(SqlRowSet accountResult)
    {

    }



}
