package org.library;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

@QuarkusTest
class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        when()
            .get("api/books")
            .then().statusCode(200).body("size()", is(5));
    }

    @Test
    public void shouldCountAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN);
        when()
            .get("api/books/count")
            .then().statusCode(200).body(is("5"));
    }

    @Test
    public  void shouldGetBookById() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .pathParam("id", 1);
        when()
        .get("api/books/1")
            .then().statusCode(200).body("author", is("Joshua Bloch"),
                                         "title",is("Effective Java"));
    }
}