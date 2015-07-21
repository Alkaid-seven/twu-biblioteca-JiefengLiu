package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Modal.Book;

import java.io.PrintStream;
import java.util.List;

/**
 * list Book 展示，借阅，归还。
 */

public class BookService {
    private String fmt = "%1$-10s %2$-40s %3$-10s %4$10s%n";
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookService(){

    }
    private void printHeader(PrintStream printStream) {
        printStream.format(fmt,"Book Id", "Book Name", "Author", "Published Year");
        printStream.format(fmt, "------", "---------", "------", "--------------");
    }

    public void list(PrintStream printStream) {
        List<Book> books = bookDao.getAllBooks();
        printHeader(printStream);

        for (Book book : books) {
            printStream.format(fmt, book.getBookId(), book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    public Boolean checkout(String id){
        Boolean isChecked = bookDao.ischecked(id);
        if(!isChecked){
            return bookDao.checkoutBook(id);
        }else{
            return false;
        }
    }

    public Boolean returnBook(String id){
        Boolean isChecked = bookDao.ischecked(id);
        if(isChecked){
            return bookDao.returnBook(id);
        }else{
            return false;
        }
    }

    public void listChecked(PrintStream printStream) {
        printHeader(printStream);
        List<Book> checkedBooks = bookDao.getCheckedBooks();
        for(Book book: checkedBooks) {
            printStream.format(fmt, book.getBookId(), book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

}