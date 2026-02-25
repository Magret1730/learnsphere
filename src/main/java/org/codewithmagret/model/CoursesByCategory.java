package org.codewithmagret.model;

import java.util.List;

/**
 * This class represents a report of courses grouped by category.
 * It contains the category name and the number of courses in that category.
 * It is used as a Data Transfer Object (DTO) to transfer data from the service layer
 */
public class CoursesByCategory {
    private Long categoryId;
    private String categoryName;
    private List<SimpleCourse> courses;

    /**
     * Default constructor for CoursesByCategory. Required for JSON deserialization.
     */
    public CoursesByCategory() {}

    /**
     * Parameterized constructor for CoursesByCategory.
     *
     * @param categoryId the ID of the category
     * @param categoryName the name of the category
     * @param courses the list of courses in the category
     */
    public CoursesByCategory(Long categoryId, String categoryName, List<SimpleCourse> courses) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.courses = courses;
    }

    /**
     * Getters and setters for the fields of CoursesByCategory.
     * @return the category ID, category name, and list of courses
     */
    public Long getCategoryId() { return categoryId; }

    /** Setters for the fields of CoursesByCategory.
     * @param categoryId the ID of the category to set
     */
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    /** Getters for the fields of CoursesByCategory.
     * @return the name of the category
     */
    public String getCategoryName() { return categoryName; }

    /** Setters for the fields of CoursesByCategory.
     * @param categoryName the name of the category to set
     */
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    /** Getters for the fields of CoursesByCategory.
     * @return the list of courses in the category
     */
    public List<SimpleCourse> getCourses() { return courses; }

    /** Setters for the fields of CoursesByCategory.
     * @param courses the list of courses in the category to set
     */
    public void setCourses(List<SimpleCourse> courses) { this.courses = courses; }
}
