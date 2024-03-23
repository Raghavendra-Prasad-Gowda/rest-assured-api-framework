package com.book.store.api.endpoints;

import com.book.store.api.endpoints.generics.IApiResponse;
import io.restassured.response.Response;

public class ApiResponse<T> implements IApiResponse<T> {
    private T classObject;
    private Response response;
    private Exception exception;

    public ApiResponse(Class<T> classObject, Response response) {
        this.response = response;
        try{
            this.classObject = classObject.getDeclaredConstructor().newInstance();
        }catch (Exception exception){
            throw new RuntimeException("There should be a default constructor in the Response POJO");
        }
    }

    public T getResponseBodyAsClassObject() {
        try {
            classObject = (T) response.getBody().as(classObject.getClass());
        }catch (Exception exception) {
            this.exception=exception;
        }
        return classObject;
    }

    public String getResponseBodyString() {
        return response.getBody().asString();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponseObject() {
        return response;
    }

    public Exception getException() {
        return exception;
    }
}
