package org.codewithmagret.model;

/*
 * DTO for representing a simple instructor in reports.
 */
public class SimpleInstructor {
    public Long instructorId;
    public String firstName;
    public String lastName;
    public String email;

    /**
     * Default constructor for SimpleInstructor. Required for JSON deserialization.
     */
    public SimpleInstructor() {}

    /**
     * Parameterized constructor for SimpleInstructor.
     *
     * @param instructorId the ID of the instructor
     * @param firstName the first name of the instructor
     * @param lastName the last name of the instructor
     * @param email the email of the instructor
     */
    public SimpleInstructor(Long instructorId, String firstName, String lastName, String email) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Getters and setters for the fields of SimpleInstructor.
     * @return the instructor ID, first name, last name, and email
     */
    public Long getInstructorId() { return instructorId; }

    /**
     * Setters for the fields of SimpleInstructor.
     * @param instructorId the ID of the instructor to set
     */
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }

    /**
     * Getters for the fields of SimpleInstructor.
     * @return the first name of the instructor
     */
    public String getFirstName() { return firstName; }

    /**
     * Setters for the fields of SimpleInstructor.
     * @param firstName the first name of the instructor to set
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Getters for the fields of SimpleInstructor.
     * @return the last name of the instructor
     */
    public String getLastName() { return lastName; }

    /**
     * Setters for the fields of SimpleInstructor.
     * @param lastName the last name of the instructor to set
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Getters for the fields of SimpleInstructor.
     * @return the email of the instructor
     */
    public String getEmail() { return email; }

    /**
     * Setters for the fields of SimpleInstructor.
     * @param email the email of the instructor to set
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Utility method to get the full name of the instructor.
     * It handles null values and trims whitespace.
     *
     * @return the full name of the instructor, or "-" if both names are missing
     */
    public String getFullName() {
        String f = firstName == null ? "" : firstName.trim();
        String l = lastName == null ? "" : lastName.trim();
        String name = (f + " " + l).trim();
        return name.isEmpty() ? "-" : name;
    }

    /**
     * Overrides the toString method to provide a string representation of the SimpleInstructor object.
     * It includes the full name and email (if available).
     *
     * @return a string representation of the SimpleInstructor object
     */
    @Override
    public String toString() {
        return getFullName() + (email == null ? "" : " <" + email + ">");
    }
}
