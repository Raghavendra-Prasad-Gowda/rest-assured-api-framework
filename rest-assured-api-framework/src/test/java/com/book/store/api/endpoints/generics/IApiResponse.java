package com.book.store.api.endpoints.generics;

import io.restassured.response.Response;

public interface IApiResponse<T> {
    public T getResponseBodyAsClassObject();

    public String getResponseBodyString();

    public int getStatusCode();

    public String getStatusDescription();

    public Response getResponseObject();

    public Exception getException();
}
