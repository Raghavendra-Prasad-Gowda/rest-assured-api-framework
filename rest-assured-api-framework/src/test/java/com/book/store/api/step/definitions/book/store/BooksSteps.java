package com.book.store.api.step.definitions.book.store;

import com.book.store.api.cucumber.TestContext;
import com.book.store.api.data.providers.ConfigurationReader;
import com.book.store.api.models.book.store.request.pojo.AddBookRequest;
import com.book.store.api.models.book.store.request.pojo.Isbn;
import com.book.store.api.models.book.store.request.pojo.RemoveBookRequest;
import com.book.store.api.models.book.store.response.pojo.Book;
import com.book.store.api.models.book.store.response.pojo.BooksResponse;
import com.book.store.api.models.book.store.response.pojo.UserAccountResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class BooksSteps extends BaseSteps {

    public BooksSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I get the list of books that are available to add")
    public void listOfBooksAreAvailable() {
        BooksResponse booksResponseBody = getEndpointOperationsObjectManager().getBookStoreApiOperations().getListOfBooksInStore().getResponseBodyAsClassObject();
        List<Book> books = booksResponseBody.getBooksList();
        getScenarioContext().setContext("bookIsbnToBeAddedForUser", books.get(0).getIsbn());
    }

    @When("I set addBook json to current request body")
    public void addBookRequestBody() {
        Isbn bookIsbnToBeAdded = new Isbn(getScenarioContext().getContext("bookIsbnToBeAddedForUser"));
        AddBookRequest addBookRequestBody = new AddBookRequest(ConfigurationReader.getInstance().getUserid(), bookIsbnToBeAdded);
        getEndpointOperationsObjectManager().getBookStoreApiOperations().setAddBookRequestBodyToCurrentRequest(addBookRequestBody);
    }

    @Then("I add the book to my reading list")
    public void addBook() {
        getEndpointOperationsObjectManager().getBookStoreApiOperations().addBookToUser();
    }

    @When("I set removeBook json to current request body")
    public void removeBookRequestBody() {
        RemoveBookRequest removeBookRequestBody = new RemoveBookRequest(ConfigurationReader.getInstance().getUserid(), getScenarioContext().getContext("bookIsbnToBeAddedForUser"));
        getEndpointOperationsObjectManager().getBookStoreApiOperations().setRemoveBookRequestBodyToCurrentRequest(removeBookRequestBody);
    }

    @When("I remove added book from my reading list")
    public void removeBook() {
        getEndpointOperationsObjectManager().getBookStoreApiOperations().removeBookFromUser();
    }

    @Then("I Verify if book is removed from the user reading list")
    public void verifyBookRemoval() {
        UserAccountResponse userAccountResponse = getEndpointOperationsObjectManager().getBookStoreApiOperations().getUserBookAccount(ConfigurationReader.getInstance().getUserid()).getResponseBodyAsClassObject();
        Assert.assertEquals(0, userAccountResponse.getBooks().size());
    }
}
