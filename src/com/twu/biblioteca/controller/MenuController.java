package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.Service.UserManagementService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.views.BaseView;
import com.twu.biblioteca.views.MenuView;

import java.util.ArrayList;
import java.util.List;

public class MenuController implements BaseController {

    BaseView menuView;

    List<BaseController> menuList;
    UserManagementService userManagementService = UserManagementService.getInstance();

    public MenuController() {
        menuList = new ArrayList<BaseController>();

        if (userManagementService.getLoggedInUser().getAdmin()) {

            buildAdminMenu();
        } else {
            buildUserMenu();
        }

        menuView = new MenuView(menuList);
    }

    private void buildUserMenu() {

        menuList.add(new GoodListController<Book>(GoodStorageService.getBookInstance()));
        menuList.add(new GoodListController<Movie>(GoodStorageService.getMovieInstance()));

        menuList.add(new BorrowGoodController(GoodStorageService.getBookInstance()));
        menuList.add(new ReturnGoodController(GoodStorageService.getBookInstance()));

        menuList.add(new BorrowGoodController(GoodStorageService.getMovieInstance()));
        menuList.add(new ReturnGoodController(GoodStorageService.getMovieInstance()));

    }

    private void buildAdminMenu() {
        menuList.add(new GoodListController<Book>(GoodStorageService.getBookInstance()));
        menuList.add(new GoodListController<Movie>(GoodStorageService.getMovieInstance()));
        menuList.add(new CheckedListController());
    }

    @Override
    public String getDescription() {
        return "menu";
    }

    @Override
    public BaseView index() {
        return menuView;
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        try {
            Integer i = Integer.parseInt(input);
            i--;
            if (i >= 0 && i < menuList.size()) {
                return menuList.get(i);
            }

        } catch (NumberFormatException e) {

        }
        throw new UndefinedInputException();
    }
}
