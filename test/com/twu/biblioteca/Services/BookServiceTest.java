package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Modal.Book;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import com.twu.biblioteca.Services.BookService;

import static org.junit.Assert.*;


public class BookServiceTest extends TestCase {

    Book book1 = new Book("0001", "TestBook1", "qq", "2013", true, true);
    Book book2 = new Book("0002", "TestBook2", "ww", "2011", false, true);
    Book book3 = new Book("0003", "TestBook3", "mm", "2013", true, false);
    Book book4 = new Book("0004", "TestBook4", "ee", "2013", false, false);

    BookDao bookDao = new BookDao(book1, book2, book3, book4);

    private  BookService testbook = new BookService(bookDao);
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCheckout() throws Exception {
        String bookid[] = {"0001", "0002", "0003", "0004"};
        boolean result[] = {false, true, false, true};
        for(int i=0; i<result.length; i++){
            boolean testchecked = testbook.checkout(bookid[i]);
            assertEquals(result[i], testchecked);
        }
    }

    @Test
    public void testReturnBook() throws Exception {
        String bookid[] = {"0001", "0002", "0001", "0005"};
        boolean result[] = {true, true, false, false};
        for(int i=0; i<result.length; i++){
            boolean testreturn= testbook.returnBook(bookid[i]);
            assertEquals(result[i], testreturn);
        }
    }
}