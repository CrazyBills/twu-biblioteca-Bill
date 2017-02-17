package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.views.GoodListView;

import java.util.List;

public class BookListController implements BaseController {

    GoodListView<Book> goodListView = new GoodListView();
    GoodStorageService<Book> goodStorageService = GoodStorageService.getBookInstance();

    @Override
    public void index() {

        List<Book> goodLists = goodStorageService.getBookLists();

        goodListView.setGoodList(goodLists);

        System.out.println(goodListView.render());

    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        Integer id = Integer.parseInt(input);

        Book bookById = goodStorageService.getBookById(id);

        if (bookById != null && bookById.getStatus() != 0) {
            return new BookDetailController(id);
        } else {
            throw new UndefinedInputException();
        }
    }
}
