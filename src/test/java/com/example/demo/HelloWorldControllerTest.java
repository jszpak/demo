package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@SpringBootTest
public class HelloWorldControllerTest {

    @Test
    public void getHelloWorld() throws IOException, InterruptedException {
        final var client = HttpClient.newHttpClient();
        final var request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/helloworld")).GET().build();
        final var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals("HelloWorld", response.body());
    }
}
