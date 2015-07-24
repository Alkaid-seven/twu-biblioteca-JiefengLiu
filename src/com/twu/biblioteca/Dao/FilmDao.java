package com.twu.biblioteca.Dao;

import com.twu.biblioteca.Modal.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义 Film 数据CRUD操作。
 */

public class FilmDao {
    private List<Film> films= new ArrayList<Film>();

    public FilmDao(){
        films.add(new Film("001", "Forrest Gump", "Robert", "1993", "1", true));
        films.add(new Film("002", "Avatar", "Cameron", "2009", "1", true));
        films.add(new Film("003", "Furious 7", "James Wan", "2015", "1", true));
    }

    public FilmDao(Film...initfilms){
        for(Film film: initfilms){
            films.add(film);
        }
    }

    public List<Film> getMovies(){
        List<Film> filmShow= new ArrayList<Film>();
        for(Film film: films){
            if(film.getIsvalid()){
                filmShow.add(film);
            }
        }
        return filmShow;
    }

    public Boolean checkoutMovie(String Id){
        for(Film film: films){
            if(film.getFilmId().equalsIgnoreCase(Id)&&film.getIsvalid()){
                film.setIsvalid(false);
                return true;
            }
        }
        return false;
    }
}
