package org.codewithmagret;

import org.codewithmagret.config.AppConfig;
import org.codewithmagret.http.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codewithmagret.ui.ConsoleRenderer;

import java.util.Scanner;

/**
 * Main class for the application. Provides a console-based menu for viewing various reports.
 */
public class Main {
    /**
     * Main method that runs the application.
     *
     * @param args command-line arguments (not used)
     */
    static void main() {
        ApiClient apiClient = new ApiClient();
        ObjectMapper mapper = new ObjectMapper();
        ReportService reportService = new ReportService(apiClient, mapper, AppConfig.BASE_URL);
        ConsoleRenderer renderer = new ConsoleRenderer();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== REPORTS MENU ====");
            System.out.println("1) Courses by Category");
            System.out.println("2) Courses by Student");
            System.out.println("3) Instructors by Course");
            System.out.println("4) Instructors by Student");
            System.out.println("0) Exit");
            System.out.print("Choose any of the numbers above: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> renderer.printCoursesByCategory(reportService.getCoursesByCategory());
                    case "2" -> renderer.printCoursesByStudent(reportService.getCoursesByStudent());
                    case "3" -> renderer.printInstructorsByCourse(reportService.getInstructorsByCourse());
                    case "4" -> renderer.printInstructorsByStudent(reportService.getInstructorsByStudent());
                    case "0" -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
