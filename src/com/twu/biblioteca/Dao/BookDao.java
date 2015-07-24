package com.twu.biblioteca.Dao;

import com.twu.biblioteca.Modal.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义 Book 数据CRUD操做。
 */

public class BookDao {

    private List<Book> books = new ArrayList<Book>();

    public BookDao() {
        books.add(new Book("0001", "ASync JavaScript", "Trevor", "2013", false, true));
        books.add(new Book("0002", "Pragmatic Programmer", "Andrew", "2011", false, true));
        books.add(new Book("0003", "Learning JavaScript Design Patterns", "Addy", "2013", false, true));
    }

    public BookDao(Book...initbooks){
        for(Book book: initbooks) {
            books.add(book);
        }
    }
    public List<Book> getAllBooks() {
        List<Book> bookshow = new ArrayList<Book>(); // bookshow for book list to customer
        for(Book book: books){
            if(!book.getIsCheckOut()) {  //get the book which never check out to list to customer
                bookshow.add(book);
            }else{
                continue;
            }
        }
        return bookshow;
    }

    public Boolean ischecked(String id){
        List<String> BookIdList = new ArrayList<String>();
        for(Book book: books){
            if(book.getIsCheckOut()){
                BookIdList.add(book.getBookId());
            }else{
                continue;
            }
        }
        if(BookIdList.contains(id)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkoutBook(String id){

        for(Book book: books){
            if(book.getBookId().equalsIgnoreCase(id)){
                book.setIsCheckOut(true);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(String id){
        for(Book book: books){
            if(book.getBookId().equalsIgnoreCase(id)){
                book.setIsCheckOut(false);
                return true;
            }
        }
        return false;
    }

    public List<Book> getCheckedBooks(){
        List<Book> checkedbook = new ArrayList<Book>();
        for(Book book: books){
            if(book.getIsCheckOut()){
                checkedbook.add(book);
            }else{
                continue;
            }
        }
        return checkedbook;
    }
}