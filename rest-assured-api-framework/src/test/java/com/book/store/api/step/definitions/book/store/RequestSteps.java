package com.book.store.api.step.definitions.book.store;

import com.book.store.api.cucumber.TestContext;
import io.cucumber.java.en.Given;

public class RequestSteps extends BaseSteps{
    public RequestSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I Get {string} key value from {string} file and set it to request body of current request")
    public void iGetKeyValueFromJsonFileAndSetItToRequestBody(String jsonKeyValue, String jsonFileName) {

        getEndpointOperationsObjectManager().getBookStoreApiOperations().setRequestBodyFromJsonFile(jsonKeyValue,jsonFileName);
    }

}
