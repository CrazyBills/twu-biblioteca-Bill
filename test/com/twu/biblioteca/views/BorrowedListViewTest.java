package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Good;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BorrowedListViewTest {
    @Test
    public void render() throws Exception {

        List<Good> goodList = new ArrayList<>();
        Book book = new Book(1, "php", "martin", "1992");
        book.setBorrowerID("usr-test");

        goodList.add(book);

        BorrowedListView borrowedListView = new BorrowedListView(goodList);

        String shouleBe = "Here are the checked list:\n" +
                            "Name\tUser ID\tUser Name\tE-Mail\tPhone\n" +
                            "php\tusr-test\tJohn\txoxo@gmail.com\t010-1010101\n" +
                            "input 'q' to return to previous menu";

        assertEquals(shouleBe, borrowedListView.render());
    }

}