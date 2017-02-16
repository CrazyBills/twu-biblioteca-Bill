package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class BookStorageServiceTest {

    BookStorageService bookStorageService;

    @Before
    public void setUp() throws Exception {

        Constructor constructor = BookStorageService.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        bookStorageService = (BookStorageService) constructor.newInstance();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getBookLists() throws Exception {

        List<Book> bookLists = bookStorageService.getBookLists();

        assertEquals(5, bookLists.size());
    }

    @Test
    public void getBookById() throws Exception {

        Book shouldBe = new Book(1, "Java Language", "GoodWeather", "2005");

        assertEquals(shouldBe, bookStorageService.getBookById(1));
    }

    @Test
    public void shouldGetNullBookById() throws Exception {

        assertEquals(null, bookStorageService.getBookById(10));
    }

    @Test
    public void shouldBorrowBook1() throws Exception {

        boolean b = bookStorageService.borrowBookId(1);

        assertTrue(b);

        //Check borrow Status
        Book bookById = bookStorageService.getBookById(1);

        assertEquals(0, bookById.getStatus());
    }

    @Test
    public void shouldBorrowFailBook1() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.getInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(mockedService.getBookById(1)).thenReturn(book);

        boolean b = mockedService.borrowBookId(1);

        assertFalse(b);
    }

    @Test
    public void returnBookById() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.getInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(mockedService.getBookById(1)).thenReturn(book);

        boolean b = mockedService.returnBookById(1);

        assertTrue(b);
    }

    @Test
    public void shouldReturnBookFailById() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.getInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(1);
        when(mockedService.getBookById(1)).thenReturn(book);

        boolean b = mockedService.returnBookById(1);

        assertFalse(b);
    }

    public void shouldReturnBookByName() {

        Book shouldBe = new Book(1, "Java Language", "GoodWeather", "2005");

        Book book = bookStorageService.searchBookByName("Java Language");

        assertEquals(shouldBe, book);
    }

    @Test
    public void returnBookByName() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.getInstance());

        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(mockedService.searchBookByName("Java Language")).thenReturn(book);

        boolean b = mockedService.returnBookByName("Java Language");

        assertTrue(b);
    }

}