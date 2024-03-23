package com.book.store.api.models.book.store.request.pojo;

public class RemoveBookRequest {
    private String isbn;
    private String userId;

    public RemoveBookRequest(String userId, String isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
