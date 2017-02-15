package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Book;

import java.util.List;

public class BookListView implements BaseView {

    List<Book> bookList;

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String render() {

        StringBuffer resultBuffer = new StringBuffer();

        resultBuffer.append("Here are list of books:\nID\tName\n");

        bookList.stream().forEach(book -> {
            resultBuffer.append(book.getId());
            resultBuffer.append("\t");
            resultBuffer.append(book.getBookName());
            resultBuffer.append("\n");
        });

        resultBuffer.append("please Enter the id of book to explore the details");

        return resultBuffer.toString();
    }
}
