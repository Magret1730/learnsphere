package org.codewithmagret.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient httpClient;

    public ApiClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    // constructor injection for testing
    public ApiClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String get(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int status = response.statusCode();
            if (status >= 200 && status < 300) {
                return response.body();
            }

            throw new RuntimeException("HTTP " + status + " calling " + url + " - " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed calling " + url + ": " + e.getMessage(), e);
        }
    }
}
