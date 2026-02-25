package org.codewithmagret.model;

import java.util.List;

/**
 * DTO for the report of instructors by student.
 */
public class InstructorsByStudent {
    private Long studentId;
    private String firstName;
    private String lastName;
    private List<SimpleInstructor> instructors;

    /**
     * Default constructor for JSON deserialization.
     */
    public InstructorsByStudent() {}

    /**
     * Constructor to create an instance of InstructorsByStudent.
     *
     * @param studentId   The ID of the student.
     * @param firstName   The first name of the student.
     * @param lastName    The last name of the student.
     * @param instructors The list of instructors associated with the student.
     */
    public InstructorsByStudent(Long studentId, String firstName, String lastName, List<SimpleInstructor> instructors) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructors = instructors;
    }

    /**
     * Getters and setters for the fields.
     * @return the student ID, first name, last name, and list of instructors.
     */
    public Long getStudentId() { return studentId; }

    /**
     * Set the student ID.
     * @param studentId the ID of the student to set
     */
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    /**
     * Get the first name of the student.
     * @return the first name of the student
     */
    public String getFirstName() { return firstName; }

    /**
     * Set the first name of the student.
     * @param firstName the first name of the student to set
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Get the last name of the student.
     * @return the last name of the student
     */
    public String getLastName() { return lastName; }

    /**
     * Set the last name of the student.
     * @param lastName the last name of the student to set
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Get the list of instructors associated with the student.
     * @return the list of instructors
     */
    public List<SimpleInstructor> getInstructors() { return instructors; }

    /**
     * Set the list of instructors associated with the student.
     * @param instructors the list of instructors to set
     */
    public void setInstructors(List<SimpleInstructor> instructors) { this.instructors = instructors; }
}
