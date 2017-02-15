package com.twu.biblioteca.Service;
import com.twu.biblioteca.model.Book;

import java.util.List;

public class BookStorageService {

    public List<Book> getBookLists(){

        return null;
    }

    public Book getBookById(Integer id){
        return null;
    }

    public boolean borrowBookId(Integer id){
        return true;
    }

    public boolean returnBookById(Integer id){
        return true;
    }

    public boolean returnBookByName(String name){
        return true;
    }

    public Book searchBookByName(String s) {
        return null;
    }
}
