package com.techelevator.dao;


import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class JdbcUserDaoTests extends BaseDaoTests{

    private JdbcUserDao sut;

    @Before
    public void setup()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void createNewUser()
    {
//        boolean userCreated = sut.create("fred","test_password");
//        Assert.assertTrue(userCreated);
//        User user = sut.findByUsername("fred");
//        Assert.assertEquals("fred", user.getUsername());


        User newUser = new User();

        newUser.setUsername("jakey");
        newUser.setPassword("jake");

        boolean user = sut.create("jakey", "jake");
        Assert.assertEquals("jakey", newUser.getUsername());

//
//        assertUsersMatch(newUser, newUser);
//
//        User createdUser = sut.create();
//        Assert.assertNotNull("createUser should return the newly created User", createdUser);
//        Assert.assertTrue("createUser did not return an object with ID", createdUser.getId() > 0);
//        Assert.assertEquals("createTimesheet did not return a Timesheet with the correct name", newTimesheet.getDescription(), createdTimesheet.getDescription());
//
//
//        User retrievedUser = sut.create(createdUser.getUsername());
//        Assert.assertNotNull("createTimesheet failed to create department in database", retrievedTimesheet);
//        assertUsersMatch(createdUser, retrievedUser);









    }

    @Test
    public void findIdByUsername_returns_correct_id()
    {
    int id = sut.findIdByUsername("bob");
    Assert.assertEquals(1001, id);
    }

    @Test
    public void findAllUsers_returns_all_users()
    {
    List<UserDTO> users = sut.findAllUsers();
    Assert.assertEquals(2, users.size());
    }

    @Test
    public void findByUsername_returns_correct_user()
    {
        User user = sut.findByUsername("bob");
        Assert.assertEquals("bob", user.getUsername());
    }


    private void assertUsersMatch(User expected, User actual)
    {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
        Assert.assertEquals(expected.getAuthorities(), actual.getAuthorities());
    }



}
