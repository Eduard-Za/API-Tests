import data.Countries;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.ListRestResponse;
import pojo.ResponseEachCountry;
import pojo.Result;
import utils.PropertiesLoader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static data.Countries.NONEXIST;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static utils.JsonReader.getDataFromJson;

public class MainTest extends BaseTest {

    public Response response;


    @Issue("Test-1")
    @Description("Get all countries and validate that US, DE and GB were returned in the response")
    @Test
    public void validateIsPresent() {
        RestAssured.baseURI = PropertiesLoader.loadProperty("all.countries.url");
        response = when()
                .get()
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        logger.info("Get list of countries from API and check response code", ListRestResponse.class);
        ListRestResponse listRestResponse = response.as(ListRestResponse.class);
        Assert.assertTrue(200 == response.getStatusCode());
        List<String> allNamesFromApi = listRestResponse.getRestResponse()
                .getResult().stream().map(s -> s.getName()).collect(Collectors.toList());
        List<String> existentCountriesExpectedNames = Arrays.stream(Countries.values())
                .filter(countries -> countries.getIsExist() == true).map(country -> country.getName()).collect(Collectors.toList());
        logger.info("Check list contains DE, GB, US ");
        Assert.assertTrue(allNamesFromApi.containsAll(existentCountriesExpectedNames));
    }

    @Issue("Test-2")
    @Description("Get each country (US, DE and GB) individually and validate the response")
    @Test
    public void validateEachCountries() {
        Arrays.asList(Countries.values()).stream().filter(country -> country.getIsExist() == true)
                .forEach(country -> {
                    logger.info("Get response by each countries " + country);
                    response = getResponseFromCountry(country);
                    logger.info("Check status code " + country + " " + response.getStatusCode());
                    Assert.assertTrue(200 == response.getStatusCode());
                    ResponseEachCountry responseEachCountry = response.as(ResponseEachCountry.class);
                    logger.info("Check name and isoCode " + country);
                    String name = responseEachCountry.RestResponse.getResult().getName();
                    String alfa2 = responseEachCountry.RestResponse.getResult().getAlpha2_code();
                    Assert.assertTrue(name.equals(country.getName()));
                    Assert.assertTrue(alfa2.equals(country.getAlfa()));
                });
    }

    @Issue("Test-3")
    @Description("Try to get information for inexistent countries and validate the response is null")
    @Test
    public void checkNonExist() {
        response = getResponseFromCountry(NONEXIST);
        ResponseEachCountry responseEachCountry = response.as(ResponseEachCountry.class);
        logger.info("Check that response is null for " + NONEXIST);
        Boolean isNonExistentNull = responseEachCountry.getRestResponse().getResult() == null;
        Assert.assertTrue("Check that response body for NonExistent country null", isNonExistentNull);
    }

    @Issue("Test-4")
    @Description("Validate new country addition using POST")
    @Test
    public void performPostRequest() {
        ClassLoader classLoader = getClass().getClassLoader();
        logger.info("Get json for body");
        File file = new File(classLoader.getResource("postCountryBody.json").getFile());
        RestAssured.baseURI = PropertiesLoader.loadProperty("post.url");
        logger.info("Send post request and check status code");
        ResponseEachCountry responseEachCountry = given()
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(ResponseEachCountry.class);
        logger.info("Compare expected results from file with actual from API");
        Result expectedResult = (Result) getDataFromJson(PropertiesLoader.loadProperty("path.to.data"), Result.class);
        Result actualResult = responseEachCountry.getRestResponse().getResult();
        Assert.assertEquals(expectedResult, actualResult);
    }


    /**
     * @param country - country name from Enum
     * @return respons for each country
     */
    public Response getResponseFromCountry(Countries country) {
        RestAssured.baseURI = PropertiesLoader.loadProperty("base.url");
        response = when()
                .get(country.getAlfa())
                .then().contentType(ContentType.JSON)
                .extract().response();
        return response;
    }
}
