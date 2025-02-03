package org.library;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

@QuarkusIntegrationTest
public class NativeBookResourceIT extends BookResourceTest{

    @Test
    public  void shouldGetBookById() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
            .pathParam("id", 1);
        when()
            .get("api/books/1")
            .then().statusCode(200).body("author", is("Joshua Bloch"),
                                         "title",is("Effective Java"),
                                         "genre",is("Prod-IT"));
    }
}
