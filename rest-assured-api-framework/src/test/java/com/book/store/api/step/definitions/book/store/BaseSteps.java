package com.book.store.api.step.definitions.book.store;

import com.book.store.api.cucumber.ScenarioContext;
import com.book.store.api.cucumber.TestContext;
import com.book.store.api.data.providers.ConfigurationReader;
import com.book.store.api.manager.EndpointOperationsObjectManager;

public class BaseSteps {
    private ScenarioContext scenarioContext;

    private EndpointOperationsObjectManager endpointOperationsObjectManager;


    public BaseSteps(TestContext testContext) {
        scenarioContext = testContext.getScenarioContext();
        endpointOperationsObjectManager = testContext.getEndpointOperationsObjectManager();

        //Setting the Configuration Values into Context
        scenarioContext.setContext("user_id", ConfigurationReader.getInstance().getUserid());
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public EndpointOperationsObjectManager getEndpointOperationsObjectManager() {
        return endpointOperationsObjectManager;
    }

}
