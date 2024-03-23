package com.book.store.api.models.book.store.request.pojo;

import java.util.ArrayList;
import java.util.List;

public class AddBookRequest {
    private String userId;
    private List<Isbn> collectionOfIsbns;

    public AddBookRequest(String userId, Isbn isbn) {
        this.userId = userId;
        collectionOfIsbns = new ArrayList<Isbn>();
        collectionOfIsbns.add(isbn);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Isbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<Isbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
