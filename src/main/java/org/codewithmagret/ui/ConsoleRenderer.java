package org.codewithmagret.ui;

import org.codewithmagret.model.*;

import java.util.List;

/*
 * This class is responsible for rendering the results of the queries to the console.
 * It is used by the ReportService after fetching the data from the database.
 * Each method corresponds to a specific report and takes a list of rows as input.
 * The methods should handle null or empty lists gracefully and print appropriate messages.
 * The output should be formatted in a clear and readable way, using indentation and bullet points where necessary.
 */
public class ConsoleRenderer {
    /**
     * This method prints the courses grouped by category to the console.
     * It takes a list of CoursesByCategory objects as input and formats the output in a readable way.
     * If the list is null or empty, it prints a message indicating that there is no data.
     * For each category, it prints the category name and the number of courses in that category.
     * If there are no courses in a category, it indicates that as well.
     * For each course, it prints the course code and title.
     *
     * @param rows the list of CoursesByCategory objects to print
     */
    public void printCoursesByCategory(List<CoursesByCategory> rows) {
        System.out.println("\n=== Courses By Category ===");
        if (rows == null || rows.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        for (CoursesByCategory cat : rows) {
            String name = cat.getCategoryName() == null ? "-" : cat.getCategoryName();
            int count = (cat.getCourses() == null) ? 0 : cat.getCourses().size();

            System.out.println("\n==>> " + name + "  (" + count + " course" + (count == 1 ? "" : "s") + ")");

            if (count == 0) {
                System.out.println("  - (no courses)");
                continue;
            }

            for (SimpleCourse c : cat.getCourses()) {
                String code = c.getCode() == null ? "-" : c.getCode();
                String title = c.getTitle() == null ? "-" : c.getTitle();
                System.out.println("  - " + code + " | " + title);
            }
        }
    }

    /**
     * This method prints the courses taken by each student to the console.
     * It takes a list of CoursesByStudent objects as input and formats the output in a readable way.
     * If the list is null or empty, it prints a message indicating that there is no data.
     * For each student, it prints the full name and the number of courses taken by that student.
     * If there are no courses taken by a student, it indicates that as well.
     * For each course, it prints the course code and title.
     *
     * @param rows the list of CoursesByStudent objects to print
     */
    public void printCoursesByStudent(List<CoursesByStudent> rows) {
        System.out.println("\n=== Courses By Student ===");
        if (rows == null || rows.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        for (CoursesByStudent s : rows) {
            int count = (s.getCourses() == null) ? 0 : s.getCourses().size();

            System.out.println("\n==>> " + s.getFullName()
                    + "  (" + count + " course" + (count == 1 ? "" : "s") + ")");

            if (count == 0) {
                System.out.println("  - (no courses)");
                continue;
            }

            for (SimpleCourse c : s.getCourses()) {
                String code = c.getCode() == null ? "-" : c.getCode();
                String title = c.getTitle() == null ? "-" : c.getTitle();
                System.out.println("  - " + code + " | " + title);
            }
        }
    }

    /**
     * This method prints the instructors for each course to the console.
     * It takes a list of InstructorByCourse objects as input and formats the output in a readable way.
     * If the list is null or empty, it prints a message indicating that there is no data.
     * For each course, it prints the course code, title, instructor's full name, and email (if available).
     * If any of these fields are null, it uses a placeholder "-" to indicate missing data.
     *
     * @param rows the list of InstructorByCourse objects to print
     */
    public void printInstructorsByCourse(java.util.List<InstructorByCourse> rows) {
        System.out.println("\n=== Instructors By Course ===");
        if (rows == null || rows.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        System.out.printf("%-8s %-28s %-25s %-30s%n", "Code", "Course Title", "Instructor", "Email");
        System.out.println("---------------------------------------------------------------------------------------");

        for (InstructorByCourse r : rows) {
            String code = r.getCode() == null ? "-" : r.getCode();
            String title = r.getTitle() == null ? "-" : r.getTitle();

            String instructorName = "-";
            String email = "-";
            if (r.getInstructor() != null) {
                instructorName = r.getInstructor().getFullName();
                if (r.getInstructor().getEmail() != null) email = r.getInstructor().getEmail();
            }

            System.out.printf("%-8s %-28s %-25s %-30s%n", code, title, instructorName, email);
        }
    }

    /**
     * This method prints the instructors associated with each student to the console.
     * It takes a list of InstructorsByStudent objects as input and formats the output in a readable way.
     * If the list is null or empty, it prints a message indicating that there is no data.
     * For each student, it prints the full name and the number of instructors associated with that student.
     * If there are no instructors associated with a student, it indicates that as well.
     * For each instructor, it prints the instructor's full name and email (if available).
     * If any of these fields are null, it uses a placeholder "-" to indicate missing data.
     *
     * @param rows the list of InstructorsByStudent objects to print
     */
    public void printInstructorsByStudent(java.util.List<InstructorsByStudent> rows) {
        System.out.println("\n=== Instructors By Student ===");
        if (rows == null || rows.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        for (InstructorsByStudent s : rows) {
            int count = (s.getInstructors() == null) ? 0 : s.getInstructors().size();

            System.out.println("\n==>> " + s.getFullName()
                    + "  (" + count + " instructor" + (count == 1 ? "" : "s") + ")");

            if (count == 0) {
                System.out.println("  - (no instructors)");
                continue;
            }

            for (SimpleInstructor i : s.getInstructors()) {
                String name = (i == null) ? "-" : i.getFullName();
                String email = (i == null || i.getEmail() == null) ? "-" : i.getEmail();
                System.out.println("  - " + name + " | " + email);
            }
        }
    }
}
