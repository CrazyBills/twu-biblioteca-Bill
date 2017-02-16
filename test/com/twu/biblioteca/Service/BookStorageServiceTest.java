package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BookStorageServiceTest {

    BookStorageService bookStorageService = BookStorageService.getInstance();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getBookLists() throws Exception {

        List<Book> bookLists = bookStorageService.getBookLists();

        assertEquals(5,bookLists.size());
    }

    @Test
    public void getBookById() throws Exception {

        Book shouldBe = new Book(1,"Java Language","GoodWeather","2005");

        assertEquals(shouldBe,bookStorageService.getBookById(1));
    }

    @Test
    public void shouldGetNullBookById() throws Exception {


        assertEquals(null,bookStorageService.getBookById(10));
    }


    @Test
    public void shouldBorrowBook1() throws Exception {

        boolean b = bookStorageService.borrowBookId(1);

        assertTrue(b);


        //Check borrow Status
        Book bookById = bookStorageService.getBookById(1);

        assertEquals(0,bookById.getStatus());
    }

    @Test
    public void shouldBorrowFailBook1() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.class);

        Book book =  new Book(1,"Java Language","GoodWeather","2005");
        book.setStatus(0);
        when(mockedService.getBookById(1)).thenReturn(book);

        boolean b = mockedService.borrowBookId(1);

        assertFalse(b);
    }

    @Test
    public void returnBookById() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.class);

        Book book =  new Book(1,"Java Language","GoodWeather","2005");
        book.setStatus(0);
        when(mockedService.getBookById(1)).thenReturn(book);

        boolean b = mockedService.returnBookById(1);

        assertTrue(b);
    }

    @Test
    public void shouldReturnBookFailById() throws Exception {

        BookStorageService mockedService = spy(BookStorageService.class);

        Book book =  new Book(1,"Java Language","GoodWeather","2005");
        book.setStatus(1);
        when(mockedService.getBookById(1)).thenReturn(book);

        boolean b = mockedService.returnBookById(1);

        assertFalse(b);
    }

    public void shouldReturnBookByName(){

        Book shouldBe =  new Book(1,"Java Language","GoodWeather","2005");

        Book book = bookStorageService.searchBookByName("Java Language");

        assertEquals(shouldBe,book);
    }


    @Test
    public void returnBookByName() throws Exception {


        BookStorageService mockedService = spy(BookStorageService.class);

        Book book =  new Book(1,"Java Language","GoodWeather","2005");
        book.setStatus(0);
        when(mockedService.searchBookByName("Java Language")).thenReturn(book);

        boolean b = mockedService.returnBookByName("Java Language");

        assertTrue(b);
    }

}