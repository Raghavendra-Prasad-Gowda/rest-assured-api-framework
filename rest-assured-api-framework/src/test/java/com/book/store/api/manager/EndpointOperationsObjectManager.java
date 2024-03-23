package com.book.store.api.manager;

import com.book.store.api.data.providers.ConfigurationReader;
import com.book.store.api.endpoints.operations.BookStoreApiOperations;

public class EndpointOperationsObjectManager {

    private BookStoreApiOperations bookStoreApiOperations;

    public BookStoreApiOperations getBookStoreApiOperations(){
        if(bookStoreApiOperations == null ){
            bookStoreApiOperations = new BookStoreApiOperations(ConfigurationReader.getInstance().getBaseurl());
            return bookStoreApiOperations;
        }
        return bookStoreApiOperations;
    }
}
