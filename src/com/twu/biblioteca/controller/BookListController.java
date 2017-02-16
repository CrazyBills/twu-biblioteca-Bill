package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.BookStorageService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.views.BookListView;

import java.util.List;

public class BookListController implements BaseController {

    BookListView bookListView = new BookListView();
    BookStorageService bookStorageService = new BookStorageService();

    @Override
    public void index() {

        List<Book> bookLists = bookStorageService.getBookLists();

        bookListView.setBookList(bookLists);

        System.out.println(bookListView.render());

    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        Integer id = Integer.parseInt(input);

        Book bookById = bookStorageService.getBookById(id);

        if (bookById.getStatus() != 0 && bookById != null) {
            return new BookDetailController(id);
        } else {
            throw new UndefinedInputException();
        }
    }
}
