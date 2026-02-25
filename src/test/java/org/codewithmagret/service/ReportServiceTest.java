package org.codewithmagret.service;

import org.codewithmagret.ReportService;
import org.codewithmagret.http.ApiClient;
import org.codewithmagret.model.CoursesByCategory;
import org.codewithmagret.model.CoursesByStudent;
import org.codewithmagret.model.InstructorByCourse;
import org.codewithmagret.model.InstructorsByStudent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {
    @Mock
    ApiClient apiClient;

    private ReportService reportService;
    private final String baseUrl = "http://localhost:8080/api/v1/reports";

    @BeforeEach
    public void setUp() {
        reportService = new ReportService(apiClient, new com.fasterxml.jackson.databind.ObjectMapper(), baseUrl);
    }

    @Test
    public void getCoursesByCategory_callsCorrectEndpoint_andParsesJson() {
        String json = """
          [
            {
              "categoryId": 1,
              "categoryName": "Cloud Computing",
              "courses": [
                {
                  "courseId": 1,
                  "title": "Data Structures",
                   "code": "CS102"
                }
              ]
            }
          ]
        """;

        when(apiClient.get(anyString())).thenReturn(json);

        List<CoursesByCategory> result = reportService.getCoursesByCategory();

        // verify endpoint
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).get(urlCaptor.capture());
        assertEquals(baseUrl + "/coursesByCategories", urlCaptor.getValue());

        // verify parsing
        assertEquals(1, result.size());
        assertEquals("Cloud Computing", result.getFirst().categoryName);
        assertEquals(1, result.getFirst().courses.size());
        assertEquals("Data Structures", result.getFirst().courses.getFirst().title);
    }

    @Test
    public void getCoursesByCategory_handlesEmptyCourses() {
        String json = """
          [
            {
              "categoryId": 1,
              "categoryName": "Cloud Computing",
              "courses": []
            }
          ]
        """;

        when(apiClient.get(anyString())).thenReturn(json);

        List<CoursesByCategory> result = reportService.getCoursesByCategory();

        // verify parsing
        assertEquals(1, result.size());
        assertEquals("Cloud Computing", result.getFirst().categoryName);
        assertEquals(0, result.getFirst().courses.size());
    }

    @Test
    void getCoursesByStudent_handlesEmptyCourses() {
        String json = """
          [
            {
              "studentId": 1,
              "firstName": "Temi",
              "lastName": "Oluwaseun",
              "courses": []
            }
          ]
        """;
        when(apiClient.get(anyString())).thenReturn(json);

        List<CoursesByStudent> result = reportService.getCoursesByStudent();

        // verify endpoint
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).get(urlCaptor.capture());
        assertEquals(baseUrl + "/coursesByStudents", urlCaptor.getValue());

        assertEquals(1, result.size());
        assertNotNull(result.getFirst().courses);
        assertTrue(result.getFirst().courses.isEmpty());
    }

    @Test
    void getCoursesByStudent_handlesNullCourses() {
        String json = """
          [
            {
              "studentId": 1,
              "firstName": "Temi",
              "lastName": "Oluwaseun",
              "courses": [
                {
                  "courseId": 1,
                  "title": "Data Structures",
                   "code": "CS102"
                }
              ]
            }
          ]
        """;
        when(apiClient.get(anyString())).thenReturn(json);

        List<CoursesByStudent> result = reportService.getCoursesByStudent();

        // verify endpoint
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).get(urlCaptor.capture());
        assertEquals(baseUrl + "/coursesByStudents", urlCaptor.getValue());

        // verify parsing
        assertEquals("Temi", result.getFirst().firstName);
        assertEquals("Oluwaseun", result.getFirst().lastName);
        assertEquals(1, result.size());
        assertEquals("Data Structures", result.getFirst().courses.getFirst().title);
        assertEquals("CS102", result.getFirst().courses.getFirst().code);
        assertNotNull(result.getFirst().courses);
        assertEquals(1, result.getFirst().courses.size());
    }

    @Test
    void getInstructorByCourse_parsesInstructorObject() {
        String json = """
          [
            {
              "courseId": 10,
              "title": "Data Structures",
              "code": "CS102",
              "instructor": {
                "instructorId": 2,
                "firstName": "Sarah",
                "lastName": "Ng",
                "email": "sarah.ng@keyin.ca"
              }
            }
          ]
        """;
        when(apiClient.get(anyString())).thenReturn(json);

        List<InstructorByCourse> result = reportService.getInstructorsByCourse();

        // verify endpoint
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).get(urlCaptor.capture());
        assertEquals(baseUrl + "/instructorsByCourses", urlCaptor.getValue());

        // verify parsing
        assertEquals(1, result.size());
        assertEquals(10L, result.getFirst().courseId);
        assertEquals("Data Structures", result.getFirst().title);
        assertEquals("CS102", result.getFirst().code);
        assertNotNull(result.getFirst().instructor);
        assertEquals(2L, result.getFirst().instructor.instructorId);
        assertEquals("Sarah", result.getFirst().instructor.firstName);
        assertEquals("Ng", result.getFirst().instructor.lastName);
        assertEquals("sarah.ng@keyin.ca", result.getFirst().instructor.email);
    }

    @Test
    void getInstructorsByStudent_parsesInstructorList() {
        String json = """
          [
            {
              "studentId": 1,
              "firstName": "Temi",
              "lastName": "Oyedele",
              "instructors": [
                { "instructorId": 1, "firstName": "Jamie", "lastName": "Kells", "email": "jamie.kells@keyin.ca" },
                { "instructorId": 2, "firstName": "Sarah", "lastName": "Ng", "email": "sarah.ng@keyin.ca" }
              ]
            }
          ]
        """;
        when(apiClient.get(anyString())).thenReturn(json);

        List<InstructorsByStudent> result = reportService.getInstructorsByStudent();

        // verify endpoint
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).get(urlCaptor.capture());
        assertEquals(baseUrl + "/instructorsByStudents", urlCaptor.getValue());

        // verify parsing
        assertEquals(1, result.size());
        assertEquals(2, result.getFirst().instructors.size());
        assertEquals("Jamie", result.getFirst().instructors.getFirst().firstName);
        assertEquals("Kells", result.getFirst().instructors.getFirst().lastName);
        assertEquals("jamie.kells@keyin.ca", result.getFirst().instructors.getFirst().email);
        assertEquals("Sarah", result.getFirst().instructors.get(1).firstName);
        assertEquals("Ng", result.getFirst().instructors.get(1).lastName);
        assertEquals("sarah.ng@keyin.ca", result.getFirst().instructors.get(1).email);
    }

    @Test
    void throwsHelpfulErrorWhenJsonIsInvalid() {
        when(apiClient.get(anyString())).thenReturn("not-json");

        RuntimeException ex = assertThrows(RuntimeException.class, () -> reportService.getCoursesByCategory());
        assertTrue(ex.getMessage().contains("Failed to parse JSON"));
    }
}
