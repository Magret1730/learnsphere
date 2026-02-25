package org.codewithmagret.model;

import java.util.List;

/**
 * DTO for the report of instructors by student.
 */
public class InstructorsByStudent {
    /**
     * The ID of the student.
     * This field uniquely identifies each student in the system, allowing us to associate instructors with the correct student.
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
     * The list of instructors associated with the student.
     * This field contains the instructors that are associated with the student, allowing us to see which instructors are linked to each student.
     */
    public List<SimpleInstructor> instructors;

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

    /**
     * Get the full name of the student by combining the first and last names.
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
     * Overrides the toString method to provide a string representation of the InstructorsByStudent object.
     * It includes the student's full name and the number of instructors associated with that student.
     *
     * @return a string representation of the InstructorsByStudent object
     */
    @Override
    public String toString() {
        int count = (instructors == null) ? 0 : instructors.size();
        return getFullName() + " (" + count + " instructors)";
    }
}
