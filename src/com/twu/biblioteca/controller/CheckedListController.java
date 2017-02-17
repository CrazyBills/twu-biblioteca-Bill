package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.views.BaseView;
import com.twu.biblioteca.views.BorrowedListView;

import java.util.List;

public class CheckedListController implements BaseController {



    @Override
    public String getDescription() {
        return "Checked list";
    }

    @Override
    public BaseView index() {

        List checkedGoodLists = GoodStorageService.getBookInstance().getCheckedGoodLists();
       checkedGoodLists.addAll( GoodStorageService.getMovieInstance().getCheckedGoodLists());
        BorrowedListView borrowedListView = new BorrowedListView(checkedGoodLists);
        return borrowedListView;
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, OperationFailException {

        return null;
    }
}
