package com.book.store.api.models.book.store.response.pojo;

import java.util.List;

public class UserAccountResponse {
    public String userId;
    public String username;
    public List<Book> books;

    public UserAccountResponse() {

    }

    public String getUserID() {
        return userId;
    }

    public void setUserID(String userID) {
        this.userId = userID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
