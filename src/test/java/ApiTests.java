import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class ApiTests {


    @Test
    void getUsersSuccessTestFirstPage() {
        String pageNumber = "1";
        get("https://reqres.in/api/users?page=" + pageNumber)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void createUserSuccessTest() {
        String name = "Kostya";
        String job = "QA";

        String userData = "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}";

        given()
                .body(userData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is(name))
                .body("job", is(job));

    }

    @Test
    void updateUserSuccessTestPut() {
        String name = "Kostya";
        String job = "Automation QA";

        String userData = "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}";

        given()
                .body(userData)
                .contentType(JSON)
                .log().uri()
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is(name))
                .body("job", is(job));

    }

    @Test
    void updateUserSuccessTestPatch() {
        String name = "Kostya";
        String job = "Automation QA";

        String userData = "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}";

        given()
                .body(userData)
                .contentType(JSON)
                .log().uri()
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is(name))
                .body("job", is(job));

    }


    @Test
    void deleteUserSuccessTest() {
        String id = "2";
        delete("https://reqres.in/api/users/" + id)
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

}
