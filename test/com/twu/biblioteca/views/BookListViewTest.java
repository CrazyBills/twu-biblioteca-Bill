package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookListViewTest {

    BookListView bookListView;

    @Before
    public void setUp() {

        bookListView = new BookListView();
    }

    @Test
    public void render() throws Exception {

        List<Book> testList = new ArrayList<>();

        testList.add(new Book(1, "Java Language", "GoodWeather", "2005"));

        bookListView.setBookList(testList);

        String expectedString = "Here are list of books:\nID\tName\n" +
                "1\tJava Language\n" +
                "please Enter the id of book to explore the details";

        assertEquals(expectedString, bookListView.render());
    }

}