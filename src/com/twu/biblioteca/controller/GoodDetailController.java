package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Good;
import com.twu.biblioteca.views.GoodDetailView;

class GoodDetailController implements BaseController {

    public GoodDetailController(Integer goodID, GoodStorageService goodStorageService) {
        this.goodID = goodID;
        this.goodStorageService = goodStorageService;
    }

    GoodStorageService goodStorageService;
    private Integer goodID;

    public Integer getGoodID() {
        return goodID;
    }

    @Override
    public void index() {
        Good good = goodStorageService.getGoodById(this.goodID);
        GoodDetailView goodDetailView = new GoodDetailView(good);
        System.out.println(goodDetailView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {
        return null;
    }
}
