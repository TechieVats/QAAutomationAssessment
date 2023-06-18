package api.stepdefinition;

import api.utils.ApiActions;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DogsApi {

    ApiActions apiActions = new ApiActions();
    @Given("the Dog API base URI is set")
    public void theDogAPIBaseURIIsSet() {
        apiActions.setBaseURI();
    }

    @When("user access the dog api {string}")
    public void userAccessTheDogApi(String endpoint) {
        apiActions.getDogBreeds(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int actualStatusCode) {
        apiActions.validatingStatusCode(actualStatusCode);
    }

    @And("the response should contain the {string} breed in the list of dog breeds")
    public void theResponseShouldContainTheBreedInTheListOfDogBreeds(String breed) {
        apiActions.validateRetrieverBreedPresent(breed);
    }


    @When("user request to retrieve the list of sub-breeds for {string}")
    public void userRequestToRetrieveTheListOfSubBreedsFor(String endpoint) {
        apiActions.getDogSubBreeds(endpoint);
    }

    @And("the response should contain sub-breeds for retriever")
    public void theResponseShouldContainSubBreedsForRetriever() {
        apiActions.validatingSubBreedsOfRetriever();
    }


    @When("user request to retrieve the list of random images {string}")
    public void userRequestToRetrieveTheListOfRandomImages(String endpoint) {
        apiActions.getDogRandomImage(endpoint);
    }

    @And("the response body should contain a valid image URL")
    public void theResponseBodyShouldContainAValidImageURL() {
        apiActions.validateImageLinkInResponse();
    }

}
