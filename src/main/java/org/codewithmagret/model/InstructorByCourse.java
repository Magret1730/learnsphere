package org.codewithmagret.model;

/**
 * DTO for InstructorByCourse report
 */
public class InstructorByCourse {
    private Long courseId;
    private String title;
    private String code;
    private SimpleInstructor instructor;

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
}
