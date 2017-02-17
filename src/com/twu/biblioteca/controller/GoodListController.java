package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Good;
import com.twu.biblioteca.views.GoodListView;

import java.util.List;

public class GoodListController<T extends Good> implements BaseController {

    GoodListView<T> goodListView = new GoodListView();
    GoodStorageService<T> goodStorageService;

    public GoodListController(   GoodStorageService<T> goodStorageService){
        this.goodStorageService = goodStorageService;
    }

    @Override
    public void index() {

        List<T> goodLists = goodStorageService.getGoodLists();

        goodListView.setGoodList(goodLists);

        System.out.println(goodListView.render());

    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        Integer id = Integer.parseInt(input);

        T bookById = goodStorageService.getGoodById(id);

        if (bookById != null && bookById.getStatus() != 0) {
            return new GoodDetailController(id,goodStorageService);
        } else {
            throw new UndefinedInputException();
        }
    }
}
