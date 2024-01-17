package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final Faker faker = new Faker(new Locale("eu-US"));
    public String name = faker.name().fullName();
    public String job = faker.job().field();
    public String userId = "2";
    public String pageId = "2";
    public int numberOfDataPerPage = 6;

}
