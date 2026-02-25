// src/test/java/org/codewithmagret/ui/ConsoleRendererTest.java
package org.codewithmagret.ui;

import org.codewithmagret.model.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ConsoleRenderer class.
 */
class ConsoleRendererTest {

    private ConsoleRenderer renderer;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    /**
     * Sets up the ConsoleRenderer instance and redirects System.out to capture output for testing.
     */
    @BeforeEach
    void setUp() {
        renderer = new ConsoleRenderer();
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restores the original System.out after each test.
     */
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Tests that printCoursesByCategory prints the correct header and "No data." message when given null or empty input.
     */
    @Test
    void printCoursesByCategory_printsNoDataWhenNull() {
        renderer.printCoursesByCategory(null);

        String output = outContent.toString();
        assertTrue(output.contains("=== Courses By Category ==="));
        assertTrue(output.contains("No data."));
    }

    /**
     * Tests that printCoursesByCategory prints the category name and courses correctly when given valid input.
     */
    @Test
    void printCoursesByCategory_printsNoDataWhenEmpty() {
        renderer.printCoursesByCategory(List.of());

        String output = outContent.toString();
        assertTrue(output.contains("=== Courses By Category ==="));
        assertTrue(output.contains("No data."));
    }

    /**
     * Tests that printCoursesByCategory prints the category name and courses correctly when given valid input.
     */
    @Test
    void printCoursesByCategory_printsCategoryAndCourses() {
        SimpleCourse c1 = new SimpleCourse(10L, "Data Structures", "CS102");
        SimpleCourse c2 = new SimpleCourse(11L, "Algorithms", "CS201");

        CoursesByCategory row = new CoursesByCategory(1L, "Computer Science", List.of(c1, c2));

        renderer.printCoursesByCategory(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("=== Courses By Category ==="));
        assertTrue(output.contains("==>> Computer Science  (2 courses)"));
        assertTrue(output.contains("  - CS102 | Data Structures"));
        assertTrue(output.contains("  - CS201 | Algorithms"));
    }

    /**
     * Tests that printCoursesByCategory prints the correct message when the courses list is null.
     */
    @Test
    void printCoursesByCategory_printsNoCoursesMessageWhenCoursesNull() {
        CoursesByCategory row = new CoursesByCategory(1L, "Cloud & DevOps", null);

        renderer.printCoursesByCategory(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("==>> Cloud & DevOps  (0 courses)"));
        assertTrue(output.contains("  - (no courses)"));
    }

    /**
     * Tests that printCoursesByCategory uses a dash ("-") for null category names and course fields.
     */
    @Test
    void printCoursesByCategory_usesDashForNullFieldsInCourseOrCategoryName() {
        SimpleCourse c1 = new SimpleCourse(10L, null, null);
        CoursesByCategory row = new CoursesByCategory(1L, null, List.of(c1));

        renderer.printCoursesByCategory(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("==>> -  (1 course)"));
        assertTrue(output.contains("  - - | -"));
    }

    /**
     * Tests that printCoursesByStudent prints the correct header and "No data." message when given null or empty input.
     */
    @Test
    void printCoursesByStudent_printsNoDataWhenNull() {
        renderer.printCoursesByStudent(null);

        String output = outContent.toString();
        assertTrue(output.contains("=== Courses By Student ==="));
        assertTrue(output.contains("No data."));
    }

    /**
     * Tests that printCoursesByStudent prints the correct header and "No data." message when given an empty list.
     */
    @Test
    void printCoursesByStudent_printsStudentAndCourses() {
        SimpleCourse c1 = new SimpleCourse(10L, "AWS Foundations", "AWS-101");
        CoursesByStudent row = new CoursesByStudent(1L, "Temi", "Oyel", List.of(c1));

        renderer.printCoursesByStudent(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("=== Courses By Student ==="));
        assertTrue(output.contains("==>> Temi Oyel  (1 course)"));
        assertTrue(output.contains("  - AWS-101 | AWS Foundations"));
    }

    /**
     * Tests that printCoursesByStudent prints the correct message when the courses list is null.
     */
    @Test
    void printCoursesByStudent_printsNoCoursesMessageWhenEmpty() {
        CoursesByStudent row = new CoursesByStudent(1L, "Aisha", "Bello", List.of());

        renderer.printCoursesByStudent(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("==>> Aisha Bello  (0 courses)"));
        assertTrue(output.contains("  - (no courses)"));
    }

    /**
     * Tests that printCoursesByStudent uses a dash ("-") for null course fields.
     */
    @Test
    void printCoursesByStudent_usesDashForNullCourseFields() {
        SimpleCourse c1 = new SimpleCourse(10L, null, null);
        CoursesByStudent row = new CoursesByStudent(1L, "John", "Doe", List.of(c1));

        renderer.printCoursesByStudent(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("==>> John Doe"));
        assertTrue(output.contains("  - - | -"));
    }

    /**
     * Tests that printInstructorsByCourse prints the correct header and "No data." message when given null or empty input.
     */
    @Test
    void printInstructorsByCourse_printsNoDataWhenNull() {
        renderer.printInstructorsByCourse(null);

        String output = outContent.toString();
        assertTrue(output.contains("=== Instructors By Course ==="));
        assertTrue(output.contains("No data."));
    }

    /**
     * Tests that printInstructorsByCourse prints the correct header and "No data." message when given an empty list.
     */
    @Test
    void printInstructorsByCourse_printsTableWithInstructor() {
        SimpleInstructor instructor = new SimpleInstructor(2L, "Sarah", "Ng", "sarah.ng@keyin.ca");
        InstructorByCourse row = new InstructorByCourse(10L, "Data Structures", "CS102", instructor);

        renderer.printInstructorsByCourse(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("=== Instructors By Course ==="));
        assertTrue(output.contains("Code"));
        assertTrue(output.contains("Course Title"));
        assertTrue(output.contains("Instructor"));
        assertTrue(output.contains("Email"));

        // Check row content (formatted table)
        assertTrue(output.contains("CS102"));
        assertTrue(output.contains("Data Structures"));
        assertTrue(output.contains("Sarah Ng"));
        assertTrue(output.contains("sarah.ng@keyin.ca"));
    }

    /**
     * Tests that printInstructorsByCourse uses a dash ("-") for null course fields and instructor information.
     */
    @Test
    void printInstructorsByCourse_usesDashWhenInstructorIsNull() {
        InstructorByCourse row = new InstructorByCourse(10L, "Data Structures", "CS102", null);

        renderer.printInstructorsByCourse(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("CS102"));
        assertTrue(output.contains("Data Structures"));
        assertTrue(output.contains(" - "));
    }

    /**
     * Tests that printInstructorsByCourse uses a dash ("-") for null course fields and instructor information.
     */
    @Test
    void printInstructorsByCourse_usesDashWhenCourseFieldsNull() {
        SimpleInstructor instructor = new SimpleInstructor(2L, "Jamie", "Kells", null);
        InstructorByCourse row = new InstructorByCourse(10L, null, null, instructor);

        renderer.printInstructorsByCourse(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("-"));
        assertTrue(output.contains("Jamie Kells"));
        assertTrue(output.contains("-"));
    }

    /**
     * Tests that printInstructorsByStudent prints the correct header and "No data." message when given null or empty input.
     */
    @Test
    void printInstructorsByStudent_printsNoDataWhenEmpty() {
        renderer.printInstructorsByStudent(List.of());

        String output = outContent.toString();
        assertTrue(output.contains("=== Instructors By Student ==="));
        assertTrue(output.contains("No data."));
    }

    /**
     * Tests that printInstructorsByStudent prints the correct header and "No data." message when given null input.
     */
    @Test
    void printInstructorsByStudent_printsStudentAndInstructors() {
        SimpleInstructor i1 = new SimpleInstructor(1L, "Jamie", "Kells", "jamie.kells@keyin.ca");
        SimpleInstructor i2 = new SimpleInstructor(2L, "Sarah", "Ng", "sarah.ng@keyin.ca");

        InstructorsByStudent row = new InstructorsByStudent(1L, "Temi", "Oyedele", List.of(i1, i2));

        renderer.printInstructorsByStudent(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("=== Instructors By Student ==="));
        assertTrue(output.contains("==>> Temi Oyedele  (2 instructors)"));
        assertTrue(output.contains("  - Jamie Kells | jamie.kells@keyin.ca"));
        assertTrue(output.contains("  - Sarah Ng | sarah.ng@keyin.ca"));
    }

    /**
     * Tests that printInstructorsByStudent prints the correct message when the instructors list is null.
     */
    @Test
    void printInstructorsByStudent_printsNoInstructorsMessageWhenNullList() {
        InstructorsByStudent row = new InstructorsByStudent(1L, "Michael", "Johnson", null);

        renderer.printInstructorsByStudent(List.of(row));

        String output = outContent.toString();
        assertTrue(output.contains("==>> Michael Johnson  (0 instructors)"));
        assertTrue(output.contains("  - (no instructors)"));
    }
}
