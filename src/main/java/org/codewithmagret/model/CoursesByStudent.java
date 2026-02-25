package org.codewithmagret.model;

import java.util.List;

/**
 * DTO for the report of courses by student.
 */
public class CoursesByStudent {
    /**
     * The ID of the student.
     * This field uniquely identifies each student in the system, allowing us to associate courses with the correct student.
     */
    public Long studentId;

    /**
     * The first name of the student.
     * This field is used to provide a human-readable name for the student, which can be displayed in the UI or reports.
     */
    public String firstName;

    /**
     * The last name of the student.
     * This field is used to provide a human-readable name for the student, which can be displayed in the UI or reports.
     */
    public String lastName;

    /**
     * The list of courses taken by the student.
     * This field contains the courses that the student is enrolled in, allowing us to see which courses are associated with each student.
     */
    public List<SimpleCourse> courses;

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

    /**
     * Returns the full name of the student by combining the first name and last name.
     * If both names are null or empty, it returns a placeholder "-".
     *
     * @return the full name of the student or "-" if both names are empty
     */
    public String getFullName() {
        String f = firstName == null ? "" : firstName.trim();
        String l = lastName == null ? "" : lastName.trim();
        String name = (f + " " + l).trim();
        return name.isEmpty() ? "-" : name;
    }

    /**
     * Overrides the toString method to provide a string representation of the CoursesByStudent object.
     * It includes the full name of the student and the number of courses taken by that student.
     *
     * @return a string representation of the CoursesByStudent object
     */
    @Override
    public String toString() {
        int count = (courses == null) ? 0 : courses.size();
        return getFullName() + " (" + count + " courses)";
    }
}
