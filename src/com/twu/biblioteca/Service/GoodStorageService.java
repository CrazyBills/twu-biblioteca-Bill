package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Good;
import com.twu.biblioteca.model.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GoodStorageService<T extends Good> {

    private static GoodStorageService<Book> bookInstance;
   HashMap<Integer, T> storage;

    public String getStoredType() {
        return storedType;
    }

    public void setStoredType(String storedType) {
        this.storedType = storedType;
    }

    private String storedType;

    private GoodStorageService()
    {

    }

    public static GoodStorageService getBookInstance() {

        if (bookInstance == null) {
            bookInstance = new GoodStorageService<Book>();

            HashMap<Integer, Book> storage;
            storage = new HashMap<Integer, Book>();
            storage.put(1, new Book(1, "Java Language", "GoodWeather", "2005"));
            storage.put(2, new Book(2, "Game Of Thrones", "Martin", "2008"));
            storage.put(3, new Book(3, "AngularJS", "Google inc.", "2015"));
            storage.put(4, new Book(4, "Computer Architecture", "John", "2005"));
            storage.put(5, new Book(5, "Falling Slowly", "Bob", "2005"));

            Book book = new Book(6, "Refactoring", "Martin", "2010");
            book.setStatus(0);
            book.setBorrowerID("usr-test");

            storage.put(6,book);

            bookInstance.storage = storage;

            bookInstance.setStoredType("book");
        }
        return bookInstance;
    }

    public List<T> getGoodLists() {

        List<T> resultList = storage.values().stream().filter(book -> book.getStatus() != 0).collect(Collectors.toList());

        return resultList;
    }

    public List<T> getCheckedGoodLists() {

        List<T> resultList = storage.values().stream().filter(book -> book.getStatus() == 0).collect(Collectors.toList());

        return resultList;
    }

    public T getGoodById(Integer id) {

        return storage.get(id);
    }

    public boolean borrowGoodId(Integer id) {

        T bookById = this.getGoodById(id);
        if (bookById == null) return false;

        if (bookById.getStatus() != 0) {
            bookById.setStatus(0);
            bookById.setBorrowerID(UserManagementService.getInstance().getLoggedInUser().getAccount_id());
            return true;
        } else {
            return false;
        }
    }

    public boolean returnGoodById(Integer id) {
        T bookById = this.getGoodById(id);

        if (bookById == null) return false;

        return returnGood(bookById);
    }

    private boolean returnGood(T bookById) {
        if (bookById.getStatus() == 0) {
            bookById.setStatus(1);
            bookById.setBorrowerID(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBookByName(String name) {
        Good book = searchBookByName(name);

        if (book == null) return false;

        return returnGood((T) book);

    }

    public T searchBookByName(String s) {

        List<T> collect = storage.values().stream().filter(book -> {
            if (book.getName() == s) return true;
            return false;
        }).collect(Collectors.toList());

        if (collect.isEmpty())
            return null;
        else
            return collect.get(0);
    }

    private static GoodStorageService<Movie> movieInstance;

    public static GoodStorageService<Movie> getMovieInstance() {
        if (movieInstance == null) {
            movieInstance  = new GoodStorageService<Movie>();

            HashMap<Integer, Movie> storage;
            storage = new HashMap<Integer, Movie>();
            storage.put(1, new Movie(1,"Dr. Strange","2016","Scott",9));

            movieInstance.storage = storage;
            movieInstance.setStoredType("movie");

        }
        return movieInstance;
    }
}
