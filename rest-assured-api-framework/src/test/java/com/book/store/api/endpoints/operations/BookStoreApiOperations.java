package com.book.store.api.endpoints.operations;

import com.book.store.api.data.providers.JsonDataReader;
import com.book.store.api.endpoints.ApiResponse;
import com.book.store.api.endpoints.routes.BookStoreApiRoutes;
import com.book.store.api.models.book.store.request.pojo.AddBookRequest;
import com.book.store.api.models.book.store.request.pojo.AuthorizationRequest;
import com.book.store.api.models.book.store.request.pojo.RemoveBookRequest;
import com.book.store.api.models.book.store.response.pojo.AuthorizationResponse;
import com.book.store.api.models.book.store.response.pojo.BooksResponse;
import com.book.store.api.models.book.store.response.pojo.UserAccountResponse;
import com.rest.assured.util.RestUtil;
import io.restassured.response.Response;

public class BookStoreApiOperations {

    private RestUtil restUtilObject;

    public BookStoreApiOperations(String baseUrl) {
        restUtilObject = new RestUtil(baseUrl);
    }

    public ApiResponse<AuthorizationResponse> setAuthorizationTokenInRequestHeaderForBookUser() {
        Response response = restUtilObject.post(BookStoreApiRoutes.getGenerateTokenRoute());
        ApiResponse<AuthorizationResponse> authorizationApiResponseObject = new ApiResponse<>(AuthorizationResponse.class, response);
        restUtilObject.setRequestHeaders("Authorization", "Bearer " + authorizationApiResponseObject.getResponseBodyAsClassObject().getToken());
        System.out.println(restUtilObject.getCurrentRequestHeader("Authorization")+"**********Token");
        response.then().log().all();
        return authorizationApiResponseObject;
    }

    public ApiResponse<BooksResponse> getListOfBooksInStore() {
        
        Response response = restUtilObject.get(BookStoreApiRoutes.getBooksListRoute());
        System.out.println(restUtilObject.getCurrentRequestHeader("Content-Type")+"**********Token");
        return new ApiResponse<>(BooksResponse.class, response);
    }

    public ApiResponse<BooksResponse> addBookToUser() {
        
        Response response = restUtilObject.post(BookStoreApiRoutes.getBooksListRoute());
        return new ApiResponse<>(BooksResponse.class, response);
    }

    public Response removeBookFromUser() {
        
        Response response = restUtilObject.delete(BookStoreApiRoutes.getRemoveBookRoute());
        return response;
    }

    public ApiResponse<UserAccountResponse> getUserBookAccount(String userId) {
        
        Response response = restUtilObject.get(BookStoreApiRoutes.getUserAccountRoute(userId));
        return new ApiResponse<>(UserAccountResponse.class, response);
    }

    public void setAuthRequestBodyToCurrentRequest(AuthorizationRequest authorizationRequestBody){
        restUtilObject.getRequestSpecificationObject().body(authorizationRequestBody);
    }

    public void setAddBookRequestBodyToCurrentRequest(AddBookRequest addBookRequestBody){
        restUtilObject.getRequestSpecificationObject().body(addBookRequestBody);
    }

    public void setRemoveBookRequestBodyToCurrentRequest(RemoveBookRequest removeBookRequestBody){
        restUtilObject.getRequestSpecificationObject().body(removeBookRequestBody);
    }

    public void setRequestBodyFromJsonFile(String keyName, String fileName){
        JsonDataReader jsonDataReader = new JsonDataReader();
        restUtilObject.getRequestSpecificationObject().body(jsonDataReader.getKeyValueFromJsonFile(keyName,fileName));
    }
}
