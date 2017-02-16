package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.BookStorageService;
import com.twu.biblioteca.views.BorrowBookView;

public class BorrowBookController implements BaseController {

    BookStorageService bookStorageService = BookStorageService.getInstance();

    @Override
    public void index() {
        BorrowBookView borrowBookView = new BorrowBookView();

        System.out.println(borrowBookView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, BookOperationFailException {

        try {
            Integer id = Integer.parseInt(input);

            if (bookStorageService.borrowBookId(id)) {
                System.out.println("Thank you! Enjoy the book");
                return null;
            } else {
                throw new BookOperationFailException("That book is not available.");
            }

        } catch (NumberFormatException e) {
            throw new UndefinedInputException();
        }
    }
}
