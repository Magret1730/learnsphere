package org.codewithmagret.config;

/**
 * AppConfig class holds application-wide configuration constants.
 */
public class AppConfig {
    /**
     * BASE_URL is the base URL for the REST API endpoints.
     * It can be used throughout the application to construct full endpoint URLs.
     */
    public static final String BASE_URL = "http://localhost:8080/api/v1/reports";

    /**
     * Default constructor for AppConfig.
     * Since all members are static, this constructor is not necessary, but it can be included for clarity.
     */
    public AppConfig() {
    }
}
