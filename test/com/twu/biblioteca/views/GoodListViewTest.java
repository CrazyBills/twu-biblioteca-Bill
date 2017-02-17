package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Good;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoodListViewTest {

    GoodListView goodListView;

    @Before
    public void setUp() {

        goodListView = new GoodListView();
    }

    @Test
    public void render() throws Exception {

        List<Good> testList = new ArrayList<>();

        testList.add(new Book(1, "Java Language", "GoodWeather", "2005"));

        goodListView.setGoodList(testList);
        goodListView.setType("book");

        String expectedString = "Here are list of books:\nID\tName\n" +
                "1\tJava Language\n" +
                "please Enter the id of book to explore the details";

        assertEquals(expectedString, goodListView.render());
    }

}