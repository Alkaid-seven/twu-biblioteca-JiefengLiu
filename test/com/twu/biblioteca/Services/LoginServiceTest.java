package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Modal.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 *
 */
public class LoginServiceTest extends TestCase {

    private User user1 = new User("001", "testuer1", "crystal@qq.com", "001", "customer");
    private User user2 = new User("002", "testuer2", "crystal@qq.com", "002", "customer");
    private User user3 = new User("003", "testuer3", "crystal@qq.com", "003", "librarian");

    private UserDao testuser = new UserDao(user1, user2, user3);
    private PrintStream printStream = System.out;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private LoginService testlogin = new LoginService(printStream, reader, testuser);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLogin() throws Exception {
        boolean result1 = testlogin.isLogin("001", "001");
        assertEquals(result1, true);
        boolean result2 = testlogin.isLogin("001", "002");
        assertEquals(result2, false);

    }
}