package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Good;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class BookStorageServiceTest {

    GoodStorageService<Book> bookStorageService = GoodStorageService.getBookInstance();

    @Before
    public void setUp() throws Exception {

        HashMap<Integer, Book> storage;
        storage = new HashMap<Integer, Book>();
        storage.put(1, new Book(1, "Java Language", "GoodWeather", "2005"));
        storage.put(2, new Book(2, "Game Of Thrones", "Martin", "2008"));
        storage.put(3, new Book(3, "AngularJS", "Google inc.", "2015"));
        storage.put(4, new Book(4, "Computer Architecture", "John", "2005"));
        storage.put(5, new Book(5, "Falling Slowly", "Bob", "2005"));
        bookStorageService.storage = storage;

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getBookLists() throws Exception {

        List<Book> bookLists = bookStorageService.getGoodLists();

        assertEquals(5, bookLists.size());
    }

    @Test
    public void getBookById() throws Exception {

        Good shouldBe = new Book(1, "Java Language", "GoodWeather", "2005");

        assertEquals(shouldBe, bookStorageService.getGoodById(1));
    }

    @Test
    public void shouldGetNullBookById() throws Exception {

        assertEquals(null, bookStorageService.getGoodById(10));
    }

    @Test
    public void shouldBorrowBook1() throws Exception {

        boolean b = bookStorageService.borrowGoodId(1);

        assertTrue(b);

        //Check borrow Status
        Book bookById = bookStorageService.getGoodById(1);

        assertEquals(0, bookById.getStatus());
    }

    @Test
    public void shouldBorrowFailBook1() throws Exception {

        GoodStorageService mockedService = spy(GoodStorageService.getBookInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(mockedService.getGoodById(1)).thenReturn(book);

        boolean b = mockedService.borrowGoodId(1);

        assertFalse(b);
    }

    @Test
    public void returnBookById() throws Exception {

        GoodStorageService mockedService = spy(GoodStorageService.getBookInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(mockedService.getGoodById(1)).thenReturn(book);

        boolean b = mockedService.returnGoodById(1);

        assertTrue(b);
    }

    @Test
    public void shouldReturnBookFailById() throws Exception {

        GoodStorageService mockedService = spy(GoodStorageService.getBookInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(1);
        when(mockedService.getGoodById(1)).thenReturn(book);

        boolean b = mockedService.returnGoodById(1);

        assertFalse(b);
    }

    public void shouldReturnBookByName() {

        Good shouldBe = new Book(1, "Java Language", "GoodWeather", "2005");

        Good book = bookStorageService.searchBookByName("Java Language");

        assertEquals(shouldBe, book);
    }

    @Test
    public void returnBookByName() throws Exception {

        GoodStorageService mockedService = spy(GoodStorageService.getBookInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(mockedService.searchBookByName("Java Language")).thenReturn(book);

        boolean b = mockedService.returnBookByName("Java Language");

        assertTrue(b);
    }

}