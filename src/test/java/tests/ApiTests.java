package tests;

import data.TestData;
import models.UserBodyModel;
import models.GetUsersResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Spec.*;


public class ApiTests extends TestBase {


    private final static String GET_LIST_USER_URL = "/users?page=",
            USERS_OPERATIONS_URL = "/users/";


    @Test
    @Tag("Api")
    @DisplayName("Проверка пагинации")
    void getUsersSuccessTestSecondPage() {
        TestData data = new TestData();
        GetUsersResponseModel response = step("Выполняем запрос на получение страницы", () -> given()
                .spec(successfulRequest)
                .when()
                .get(GET_LIST_USER_URL + data.pageId)
                .then()
                .spec(successfulResponse)
                .extract()
                .response()
                .as(GetUsersResponseModel.class));
        step("Проверяем page id", () ->
                assertEquals(data.pageId, response.getPage()));
        step("Проверяем количество элементов на странице", () ->
                assertEquals(data.numberOfDataPerPage, response.getData().length));

    }


    @Test
    @Tag("Api")
    @DisplayName("Создание пользователя")
    void createUserSuccessTest() {
        TestData data = new TestData();
        UserBodyModel userBodyModel = new UserBodyModel();
        userBodyModel.setName(data.name);
        userBodyModel.setJob(data.job);
        UserBodyModel response = step("Делаем запрос на создание пользователя", () -> given()
                .spec(successfulRequest)
                .when()
                .body(userBodyModel)
                .post(USERS_OPERATIONS_URL)
                .then()
                .spec(createdResponse)
                .extract()
                .as(UserBodyModel.class));
        step("Проверяем name", () ->
                assertEquals(data.name, response.getName()));
        step("Проверяем job", () ->
                assertEquals(data.job, response.getJob()));

    }

    @Test
    @Tag("Api")
    @DisplayName("Обновление пользователя PUT")
    void updateUserSuccessTestPut() {
        TestData data = new TestData();
        UserBodyModel userBodyModel = new UserBodyModel();
        userBodyModel.setName(data.name);
        userBodyModel.setJob(data.job);
        UserBodyModel response = step("Выполняем запрос на обновление пользователя", () -> given()
                .spec(successfulRequest)
                .when()
                .body(userBodyModel)
                .put(USERS_OPERATIONS_URL + data.userId)
                .then()
                .spec(successfulResponse)
                .extract()
                .as(UserBodyModel.class));
        step("Проверяем name", () ->
                assertEquals(data.name, response.getName()));
        step("Проверяем job", () ->
                assertEquals(data.job, response.getJob()));

    }

    @Test
    @Tag("Api")
    @DisplayName("Обновление пользователя PATCH")
    void updateUserSuccessTestPatch() {
        TestData data = new TestData();
        UserBodyModel userBodyModel = new UserBodyModel();
        userBodyModel.setName(data.name);
        userBodyModel.setJob(data.job);
        UserBodyModel response = step("Выполняем запрос на обновление пользователя", () -> given()
                .spec(successfulRequest)
                .when()
                .body(userBodyModel)
                .patch(USERS_OPERATIONS_URL + data.userId)
                .then()
                .spec(successfulResponse)
                .extract()
                .as(UserBodyModel.class));

        step("Проверяем name", () ->
                assertEquals(data.name, response.getName()));
        step("Проверяем job", () ->
                assertEquals(data.job, response.getJob()));

    }


    @Test
    @Tag("Api")
    @DisplayName("Успешное удаление пользователя")
    void deleteUserSuccessTest() {
        TestData data = new TestData();

        step("Выполняем запрос на удаление пользователя", () ->
                given()
                        .spec(successfulRequest)
                        .when()
                        .delete(USERS_OPERATIONS_URL + data.userId)
                        .then()
                        .spec(successfulResponseNoContent)
                        .extract()
                        .response());
    }

}
