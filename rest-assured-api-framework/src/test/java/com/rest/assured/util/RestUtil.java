package com.rest.assured.util;

import com.book.store.api.data.providers.JsonDataReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {
    private RequestSpecification request;

    public RestUtil(String baseUrl){
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    public Response get(String endpoint) {
        return request.get(endpoint);
    }

    public Response post(String endpoint) {
        return request.post(endpoint);
    }

    public Response put(String endpoint) {
        return request.put(endpoint);
    }

    public Response delete(String endpoint) {
        return request.delete(endpoint);
    }

    public void setRequestHeaders(String key, String value){
        request.headers(key,value);
    }

    public String getCurrentRequestHeader(String headerName){
        return request.get().header(headerName);
    }

    public String getCurrentRequestBody(){
        return request.get().body().toString();
    }

    public String getCurrentResponseHeader(Response response){
        return response.getBody().toString();
    }

    public Response getCurrentResponseBody(Response response){
        return response;
    }

    public void setRequestBodyFromJsonFile(String keyName, String fileName){
        JsonDataReader jsonDataReader = new JsonDataReader();
        request.body(jsonDataReader.getKeyValueFromJsonFile(keyName,fileName));
    }

    public RequestSpecification getRequestSpecificationObject(){
        return request;
    }
}
