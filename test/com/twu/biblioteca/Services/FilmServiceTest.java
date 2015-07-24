package com.twu.biblioteca.Services;

import com.twu.biblioteca.Modal.Film;
import com.twu.biblioteca.Dao.FilmDao;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */

public class FilmServiceTest extends TestCase {

    Film film1 = new Film("001", "Forrest Gump", "Robert", "1993", "1", true);
    Film film2 = new Film("002", "Avatar", "Cameron", "2009", "1", true);
    Film film3 = new Film("003", "Furious 7", "James Wan", "2015", "1", false);

    FilmDao filmDao = new FilmDao(film1, film2, film3);
    FilmService testfilm = new FilmService(filmDao);

    @Test
    public void testCheckout() throws Exception {
        String filmId[] = {"001", "003", "005"};
        boolean result[] = {true, false, false};
        for(int i=0; i<result.length; i++){
            boolean testresult = testfilm.checkout(filmId[i]);
            assertEquals(testresult, result[i]);
        }
    }
}