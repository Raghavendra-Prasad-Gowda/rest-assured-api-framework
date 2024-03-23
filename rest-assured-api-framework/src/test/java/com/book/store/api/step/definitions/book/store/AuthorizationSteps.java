package com.book.store.api.step.definitions.book.store;

import com.book.store.api.cucumber.TestContext;
import com.book.store.api.endpoints.operations.BookStoreApiOperations;
import com.book.store.api.manager.EndpointOperationsObjectManager;
import com.book.store.api.models.book.store.request.pojo.AuthorizationRequest;
import io.cucumber.java.en.Given;

public class AuthorizationSteps extends BaseSteps {
    public AuthorizationSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I Get Authorization Token for the user and set it to request header")
    public void iGetAuthorizationToken() {
          getEndpointOperationsObjectManager().getBookStoreApiOperations().setAuthorizationTokenInRequestHeaderForBookUser();
    }

}
