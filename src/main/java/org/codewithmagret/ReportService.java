package org.codewithmagret;

import org.codewithmagret.http.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.codewithmagret.model.*;

import java.util.List;

/**
 * Service class for fetching report data from the API.
 */
public class ReportService {
    /**
     * The ApiClient used to make HTTP requests to the API.
     */
    private final ApiClient apiClient;

    /**
     * The ObjectMapper used to parse JSON responses from the API.
     */
    private final ObjectMapper mapper;

    /**
     * The base URL of the API.
     */
    private final String baseUrl;

    /**
     * Constructor for ReportService.
     *
     * @param apiClient the API client to use for making HTTP requests
     * @param mapper the ObjectMapper to use for parsing JSON responses
     * @param baseUrl the base URL of the API
     */
    public ReportService(ApiClient apiClient, ObjectMapper mapper, String baseUrl) {
        this.apiClient = apiClient;
        this.mapper = mapper;
        this.baseUrl = baseUrl;
    }

    /**
     * Fetches the report of courses by category from the API.
     *
     * @return a list of CoursesByCategory objects representing the report data
     */
    public List<CoursesByCategory> getCoursesByCategory() {
        String json = apiClient.get(baseUrl + "/coursesByCategories");
        return readList(json, new TypeReference<List<CoursesByCategory>>() {});
    }

    /**
     * Fetches the report of courses by student from the API.
     *
     * @return a list of CoursesByStudent objects representing the report data
     */
    public List<CoursesByStudent> getCoursesByStudent() {
        String json = apiClient.get(baseUrl + "/coursesByStudents");
        return readList(json, new TypeReference<List<CoursesByStudent>>() {});
    }

    /**
     * Fetches the report of instructors by course from the API.
     *
     * @return a list of InstructorByCourse objects representing the report data
     */
    public List<InstructorByCourse> getInstructorsByCourse() {
        String json = apiClient.get(baseUrl + "/instructorsByCourses");
        return readList(json, new TypeReference<List<InstructorByCourse>>() {});
    }

    /**
     * Fetches the report of instructors by student from the API.
     *
     * @return a list of InstructorsByStudent objects representing the report data
     */
    public List<InstructorsByStudent> getInstructorsByStudent() {
        String json = apiClient.get(baseUrl + "/instructorsByStudents");
        return readList(json, new TypeReference<List<InstructorsByStudent>>() {});
    }

    /**
     * Helper method to read a list of objects from a JSON string.
     *
     * @param json the JSON string to parse
     * @param typeRef the TypeReference representing the type of the list to parse
     * @param <T> the type of objects in the list
     * @return a list of objects parsed from the JSON string
     */
    private <T> List<T> readList(String json, TypeReference<List<T>> typeRef) {
        try {
            return mapper.readValue(json, typeRef);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON: " + e.getMessage(), e);
        }
    }
}
