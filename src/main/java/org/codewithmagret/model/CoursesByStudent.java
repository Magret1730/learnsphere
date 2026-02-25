package org.codewithmagret.model;

import java.util.List;

/**
 * DTO for the report of courses by student.
 */
public class CoursesByStudent {
    private Long studentId;
    private String firstName;
    private String lastName;
    private List<SimpleCourse> courses;

    /**
     * Default constructor for CoursesByStudent. Required for JSON deserialization.
     */
    public CoursesByStudent() {}

    /**
     * Parameterized constructor for CoursesByStudent.
     *
     * @param studentId the ID of the student
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     * @param courses the list of courses taken by the student
     */
    public CoursesByStudent(Long studentId, String firstName, String lastName, List<SimpleCourse> courses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    /**
     * Getters and setters for the fields of CoursesByStudent.
     * @return the student ID, first name, last name, and list of courses
     */
    public Long getStudentId() { return studentId; }

    /** Setters for the fields of CoursesByStudent.
     * @param studentId the ID of the student to set
     */
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    /** Getters for the fields of CoursesByStudent.
     * @return the first name of the student
     */
    public String getFirstName() { return firstName; }

    /** Setters for the fields of CoursesByStudent.
     * @param firstName the first name of the student to set
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /** Getters for the fields of CoursesByStudent.
     * @return the last name of the student
     */
    public String getLastName() { return lastName; }

    /** Setters for the fields of CoursesByStudent.
     * @param lastName the last name of the student to set
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /** Getters for the fields of CoursesByStudent.
     * @return the list of courses taken by the student
     */
    public List<SimpleCourse> getCourses() { return courses; }

    /** Setters for the fields of CoursesByStudent.
     * @param courses the list of courses taken by the student to set
     */
    public void setCourses(List<SimpleCourse> courses) { this.courses = courses; }
}
