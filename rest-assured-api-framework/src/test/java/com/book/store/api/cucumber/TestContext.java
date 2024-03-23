package com.book.store.api.cucumber;

import com.book.store.api.manager.EndpointOperationsObjectManager;

public class TestContext {
    private ScenarioContext scenarioContext;
    private EndpointOperationsObjectManager endpointOperationsObjectManager;

    public TestContext() {

    }

    public ScenarioContext getScenarioContext() {
        if (scenarioContext == null) {
            scenarioContext = new ScenarioContext();
            return scenarioContext;
        }
        return scenarioContext;
    }

    public EndpointOperationsObjectManager getEndpointOperationsObjectManager() {
        if (endpointOperationsObjectManager == null) {
            endpointOperationsObjectManager = new EndpointOperationsObjectManager();
            return endpointOperationsObjectManager;
        }
        return endpointOperationsObjectManager;
    }
}
