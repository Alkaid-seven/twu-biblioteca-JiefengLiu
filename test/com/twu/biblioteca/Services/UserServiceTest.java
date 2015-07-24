package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Modal.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static org.junit.Assert.*;


public class UserServiceTest {

    private User user1 = new User("001-1234", "testuer1", "crystal@qq.com", "00000000000", "001", "customer");
    private User user2 = new User("002-1234", "testuer2", "crystal@qq.com", "11111111111", "002", "customer");
    private User user3 = new User("003-1234", "testuer3", "crystal@qq.com", "99999999999", "003", "librarian");

    private UserDao testuser = new UserDao(user1, user2, user3);
    private PrintStream printStream = System.out;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private UserService testuserService = new UserService(printStream, reader, testuser);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLogin() throws Exception {
        boolean result1 = testuserService.isLogin("001-1234", "001");
        assertEquals(result1, true);
        boolean result2 = testuserService.isLogin("001-1234", "002");
        assertEquals(result2, false);
    }

    @Test
    public void testGetInfo() throws Exception{
        testuserService.isLogin("001-1234", "002");
        User result1 = testuser.getInfo();
        assertEquals(null, result1);

        testuserService.isLogin("001-1234", "001");
        User result2 = testuser.getInfo();
        assertEquals(user1, result2);
    }
}