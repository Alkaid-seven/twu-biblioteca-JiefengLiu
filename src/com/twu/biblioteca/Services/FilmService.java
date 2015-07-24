package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.FilmDao;
import com.twu.biblioteca.Modal.Film;

import java.io.PrintStream;
import java.util.List;

/**
 * Movie 展示，借阅
 */

public class FilmService{

    private String fmt = "%1$-5s %2$-20s %3$-10s %4$-5s %5$5s%n";
    private FilmDao filmDao;

    public FilmService(FilmDao filmDao) {
        this.filmDao = filmDao;
    }
    private void printHeader(PrintStream printStream) {
        printStream.format(fmt, "Film Id", "Film Name", "Director", "Release Year", "Film Rating");
        printStream.format(fmt, "--------", "----------", "--------", "------------", "--");
    }

    public void list(PrintStream printStream) {
        List<Film> films = filmDao.getMovies();
        printHeader(printStream);

        for(Film film: films){
            printStream.format(fmt, film.getFilmId(), film.getName(), film.getDirector(), film.getYear(), film.getRate());
        }
    }

    public Boolean checkout(String id){
        return filmDao.checkoutMovie(id);
    }

}