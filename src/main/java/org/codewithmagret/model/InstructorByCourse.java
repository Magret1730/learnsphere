package org.codewithmagret.model;

/**
 * DTO for InstructorByCourse report
 */
public class InstructorByCourse {
    public Long courseId;
    public String title;
    public String code;
    public SimpleInstructor instructor;

    /**
     * Default constructor for InstructorByCourse. Required for JSON deserialization.
     */
    public InstructorByCourse() {}

    /**
     * Parameterized constructor for InstructorByCourse.
     *
     * @param courseId the ID of the course
     * @param title the title of the course
     * @param code the code of the course
     * @param instructor the instructor of the course
     */
    public InstructorByCourse(Long courseId, String title, String code, SimpleInstructor instructor) {
        this.courseId = courseId;
        this.title = title;
        this.code = code;
        this.instructor = instructor;
    }

    /**
     * Getters and setters for the fields of InstructorByCourse.
     * @return the course ID, title, code, and instructor
     */
    public Long getCourseId() { return courseId; }

    /**
     * Setters for the fields of InstructorByCourse.
     * @param courseId the ID of the course to set
     */
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    /**
     * Getters for the fields of InstructorByCourse.
     * @return the title of the course
     */
    public String getTitle() { return title; }

    /**
     * Setters for the fields of InstructorByCourse.
     * @param title the title of the course to set
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Getters for the fields of InstructorByCourse.
     * @return the code of the course
     */
    public String getCode() { return code; }

    /**
     * Setters for the fields of InstructorByCourse.
     * @param code the code of the course to set
     */
    public void setCode(String code) { this.code = code; }

    /**
     * Getters for the fields of InstructorByCourse.
     * @return the instructor of the course
     */
    public SimpleInstructor getInstructor() { return instructor; }

    /**
     * Setters for the fields of InstructorByCourse.
     * @param instructor the instructor of the course to set
     */
    public void setInstructor(SimpleInstructor instructor) { this.instructor = instructor; }

    /**
     * Overrides the toString method to provide a string representation of the InstructorByCourse object.
     * It includes the course code, title, and instructor's full name (or "-" if any of these fields are null).
     *
     * @return a string representation of the InstructorByCourse object
     */
    @Override
    public String toString() {
        String i = (instructor == null) ? "-" : instructor.getFullName();
        return String.format("%s | %s -> %s", safe(code), safe(title), i);
    }

    /**
     * Utility method to safely handle null values for strings.
     * If the input string is null, it returns a default value ("-").
     *
     * @param s the input string to check
     * @return the original string if it's not null, or "-" if it is null
     */
    private String safe(String s) {
        return s == null ? "-" : s;
    }
}
