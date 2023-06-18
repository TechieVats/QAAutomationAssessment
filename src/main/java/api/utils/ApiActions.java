package api.utils;

import config.Configuration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiActions {

    public RequestSpecification request = RestAssured.given();
    private static Logger Log = LogManager.getLogger(ApiActions.class.getName());
    private static final String CONTENT_TYPE = "application/json";
    private Configuration config = new Configuration();

    Response response = null;

    public void getDogBreeds(String endpoint) {
        setHeaderAsContentType(request);
        response = request.get(endpoint);
        Log.info("DOG API GET Call Successful");
    }

    public void getDogSubBreeds(String endpoint) {
        setHeaderAsContentType(request);
        response = request.get(endpoint);
        Log.info("DOG Sub Breeds API GET Call Successful");
    }

    public void getDogRandomImage(String endpoint) {
        setHeaderAsContentType(request);
        response = request.get(endpoint);
        Log.info("DOG Random Image API GET Call Successful");
    }

    public RequestSpecification setBaseURI() {

        try {
            String baseUri = config.getPropertyValue("DOG_API_BASE_URI");
            request = request.baseUri(baseUri);
            Log.info("Base URI set for the API call: " + baseUri);
            return request;
        } catch (Exception e) {
            Log.error("Failed to set the base URI for the API call: " + e.getMessage());
            return null;
        }

    }

    private void setHeaderAsContentType(RequestSpecification request) {
        try {
            request.header("Content-Type", CONTENT_TYPE);
            Log.info("Content-Type header set: " + CONTENT_TYPE);
        } catch (Exception e) {
            Log.error("Failed to set the Content-Type header: " + e.getMessage());
        }
    }

    public void validatingStatusCode(Integer statusCodeToBeExpected) {
        try {
            Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCodeToBeExpected);
            Log.info("Passed: status code is " + statusCodeToBeExpected);
        } catch (Exception e) {
            Log.error("Fail: status code is not " + statusCodeToBeExpected);
        }
    }

    public void validatingContentType(Response res, String expectedContentType) {
        try {
            Assertions.assertThat(res.getContentType()).isEqualTo(expectedContentType);
            Log.info("Passed: Content type is validated as " + expectedContentType);
        } catch (Exception e) {
            Log.error("Fail: Content type is not as expected :" + expectedContentType);
        }
    }


    public void validateRetrieverBreedPresent(String breed) {
        try {
            JsonPath jsonPath = new JsonPath(response.getBody().asString());
            Map<String, List<String>> breeds = jsonPath.getMap("message");
            List<String> retrieverBreeds = breeds.get(breed);

            if (retrieverBreeds != null && !retrieverBreeds.isEmpty()) {
                Log.info("Retriever breed is present in the list of dog breeds");
            } else {
                throw new AssertionError("Retriever breed is not present in the list of dog breeds");
            }
        } catch (Exception e) {
            Log.error("Exception occurred while validating retriever breed: " + e.getMessage());
        }
    }


    public void validatingSubBreedsOfRetriever() {
        try {
            JsonPath jsonPath = new JsonPath(response.getBody().asString());
            List<String> subBreeds = jsonPath.getList("message");
            List<String> expectedSubBreeds = Arrays.asList("chesapeake", "curly", "flatcoated", "golden");
            Assertions.assertThat(subBreeds)
                    .describedAs("Sub-breeds of 'retriever' do not match the expected sub-breeds")
                    .satisfies(actualSubBreeds -> {
                        Log.info("Sub-breeds of 'retriever' matched the expected sub-breeds: " + actualSubBreeds);
                    })
                    .withFailMessage("Sub-breeds of 'retriever' did not match the expected sub-breeds");
        } catch (Exception e) {
            Log.error("Exception occurred while validating sub-breeds: " + e.getMessage());
        }
    }


    public void validateImageLinkInResponse() {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        String imageLink = jsonPath.getString("message");
        try {
            Assertions.assertThat(imageLink)
                    .isNotNull()
                    .isNotEmpty();

            Assertions.assertThat(imageLink)
                    .startsWith("https://images.dog.ceo/")
                    .satisfies(randomImageLink -> {
                        Log.info("Random image link is present in the response  " + randomImageLink);
                    });
        } catch (Exception e) {
            Log.error("Exception occurred while validating image link in the response: " + e.getMessage());

        }
    }
}
