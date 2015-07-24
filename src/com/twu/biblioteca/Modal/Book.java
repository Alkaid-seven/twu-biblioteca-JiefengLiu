package com.twu.biblioteca.Modal;

/**
 * 定义 Book 数据结构；
 */

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String year;
    private Boolean isCheckOut;
    private Boolean isValid;

    public Book(String bookId, String title, String author, String year, Boolean isCheckOut, Boolean isValid) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isCheckOut = isCheckOut;
        this.isValid = isValid;
    }

    public String getBookId(){
        return bookId;
    }
    public void setTitle(String title) {
        this.title= title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setIsCheckOut(Boolean isCheckOut){
        this.isCheckOut = isCheckOut;
    }

    public Boolean getIsCheckOut(){
        return isCheckOut;
    }

    public void setIsValid(Boolean isValid){
        this.isValid = isValid;
    }

    public Boolean getIsValid(){
        return isValid;
    }
}