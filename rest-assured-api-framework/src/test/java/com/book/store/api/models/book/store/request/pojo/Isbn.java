package com.book.store.api.models.book.store.request.pojo;

public class Isbn {
    private String isbn;

    public Isbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
