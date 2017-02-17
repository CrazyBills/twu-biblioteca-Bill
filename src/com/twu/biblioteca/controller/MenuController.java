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

    BaseView menuView = new MenuView();

    List<BaseController> menuList;
    UserManagementService userManagementService = UserManagementService.getInstance();

    public MenuController(){
        menuList = new ArrayList<BaseController>();

        if(userManagementService.getLoggedInUser().getAdmin()){

            buildAdminMenu();
        }else{
            buildUserMenu();
        }


    }

    private void buildUserMenu() {


    }

    private void buildAdminMenu() {

    }

    @Override
    public String getDescription() {
        return "menu";
    }

    @Override
    public void index() {
        System.out.println(menuView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        if (input.equals("1"))
            return new GoodListController<Book>(GoodStorageService.getBookInstance());
        else if (input.equals("2"))
            return new BorrowGoodController(GoodStorageService.getBookInstance());
        else if (input.equals("3"))
            return new ReturnGoodController(GoodStorageService.getBookInstance());
        else if (input.equals("4"))
            return new GoodListController<Movie>(GoodStorageService.getMovieInstance());
        else if(input.equals("5"))
            return new BorrowGoodController(GoodStorageService.getMovieInstance());
        else if(input.equals("6"))
            return new ReturnGoodController(GoodStorageService.getMovieInstance());
        else throw new UndefinedInputException();
    }
}
