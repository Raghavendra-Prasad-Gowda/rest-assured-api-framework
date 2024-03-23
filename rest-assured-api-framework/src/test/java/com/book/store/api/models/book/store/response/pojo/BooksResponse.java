package com.book.store.api.models.book.store.response.pojo;

import java.util.List;

public class BooksResponse {

    public List<Book> books;

    public BooksResponse() {

    }

    public List<Book> getBooksList() {
        return books;
    }

    public void setBooksList(List<Book> booksList) {
        this.books = booksList;
    }
}
