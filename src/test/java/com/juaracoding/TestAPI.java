package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {

    String endpointNowplaying = "https://api.themoviedb.org/3/movie/now_playing";

    @Test
    public void testMovieNowPlaying(){
        given()
                .queryParam("api_key","4bc8a6ff7edc3eefdc7e3271e8bb5fd0")
                .queryParam ("language","en-US")
                .queryParam("page","1")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing")
                .then().statusCode(200); //then kayak assert , hasilnya nanti 200
    }

    @Test
    public void testMoviePopular(){
        given()
                .queryParam("api_key","4bc8a6ff7edc3eefdc7e3271e8bb5fd0")
                .queryParam("language","en-US")
                .queryParam("page","1")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing")
                .then().statusCode(200);
    }

    @Test
    public void testMovieRating(){
        JSONObject request = new JSONObject();
        request.put("value", "8.50");

        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0YmM4YTZmZjdlZGMzZWVmZGM3ZTMyNzFlOGJiNWZkMCIsInN1YiI6IjY0ZGI4ZDcxNzcxOWQ3MDEwMjUyNTJlNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.RB6ceNsKgm4pa98R3qgkZY72J7wQMTmjXBMMMmnz1yI")
                .header("Content-Type","application/json")
                .body(request.toJSONString())

                .when()
                .post("https://api.themoviedb.org/3/movie/1083862/rating")
                .then()
                .statusCode(201); //created

    }
}
