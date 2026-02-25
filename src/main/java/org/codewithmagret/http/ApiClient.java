package org.codewithmagret.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * A simple HTTP client for making GET requests.
 */
public class ApiClient {
    private final HttpClient httpClient;

    /**
     * Default constructor that initializes the HttpClient.
     * This client will be used for making HTTP requests.
     */
    public ApiClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    /**
     * Constructor that accepts a custom HttpClient.
     * This allows for more flexible testing and configuration.
     *
     * @param httpClient the HttpClient to use for making HTTP requests
     */
    public ApiClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Makes a GET request to the specified URL and returns the response body as a string.
     *
     * @param url the URL to send the GET request to
     * @return the response body as a string
     * @throws RuntimeException if the HTTP request fails or returns a non-2xx status code
     */
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
