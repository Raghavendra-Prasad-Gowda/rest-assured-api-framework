package com.book.store.api.endpoints.operations;

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

public class BookStoreEndpointOperations {
    private RestUtil restUtilObject;

    public BookStoreEndpointOperations(String baseUrl) {
       restUtilObject = new RestUtil(baseUrl);
    }

    public ApiResponse<AuthorizationResponse> setAuthorizationTokenInRequestHeaderForBookUser() {
        Response response = restUtilObject.post(BookStoreApiRoutes.getGenerateTokenRoute());
        ApiResponse<AuthorizationResponse> authorizationApiResponseObject = new ApiResponse<>(AuthorizationResponse.class, response);
        //restUtilObject.setRequestHeaders("Authorization", "Bearer " + authorizationApiResponseObject.getResponseBodyAsClassObject().getToken());
        response.then().log().headers();
        return authorizationApiResponseObject;
    }

    public ApiResponse<BooksResponse> getListOfBooksInStore() {
        Response response = restUtilObject.get(BookStoreApiRoutes.getBooksListRoute());
        response.then().log().headers();
        return new ApiResponse<>(BooksResponse.class, response);
    }

    public ApiResponse<BooksResponse> addBookToUser(AddBookRequest addBookRequestBody) {
        Response response = restUtilObject.post(BookStoreApiRoutes.getBooksListRoute());
        response.then().log().headers();
        return new ApiResponse<>(BooksResponse.class, response);
    }

    public Response removeBookFromUser(RemoveBookRequest removeBookRequestBody) {
        Response response = restUtilObject.delete(BookStoreApiRoutes.getRemoveBookRoute());
        response.then().log().headers();
        return response;
    }

    public ApiResponse<UserAccountResponse> getUserBookAccount(String userId) {
        Response response = restUtilObject.get(BookStoreApiRoutes.getUserAccountRoute(userId));
        response.then().log().headers();
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
}
