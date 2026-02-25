package org.codewithmagret.model;

/**
 * A simple DTO for course information, used in the StudentCourseDTO to avoid circular references.
 */
public class SimpleCourse {
    private Long courseId;
    private String title;
    private String code;

    /**
     * Default constructor for SimpleCourse. Required for JSON deserialization.
     */
    public SimpleCourse() {}

    /**
     * Parameterized constructor for SimpleCourse.
     *
     * @param courseId the ID of the course
     * @param title the title of the course
     * @param code the code of the course
     */
    public SimpleCourse(Long courseId, String title, String code) {
        this.courseId = courseId;
        this.title = title;
        this.code = code;
    }

    /**
     * Getters  for courseId
     * @return the course ID
     */
    public Long getCourseId() { return courseId; }

    /**
     * Setters for courseId
     * @param courseId the ID of the course to set
     */
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    /**
     * Getters for title
     * @return the title of the course
     */
    public String getTitle() { return title; }

    /**
     * Setters for title
     * @param title the title of the course to set
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Getters for code
     * @return the code of the course
     */
    public String getCode() { return code; }

    /**
     * Setters for code
     * @param code the code of the course to set
     */
    public void setCode(String code) { this.code = code; }
}
