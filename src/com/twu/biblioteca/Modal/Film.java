package com.twu.biblioteca.Modal;

/**
 * 定义 Movie 数据结构；
 */
public class Film {
    private String filmId;
    private String name;
    private String director;
    private String year;
    private String rate;
    private boolean isvalid;

    public Film(String filmId, String name, String director, String year, String rate, boolean isvalid) {
        this.filmId = filmId;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rate = rate;
        this.isvalid = isvalid;
    }

    public String getFilmId(){
        return filmId;
    }

    public void setFilmId(String filmId){
        this.filmId = filmId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getRate(){
        return rate;
    }

    public  void setRate(String rate){
        this.rate = rate;
    }

    public boolean getIsvalid(){
        return isvalid;
    }

    public void setIsvalid(boolean isvalid){
        this.isvalid = isvalid;
    }
}