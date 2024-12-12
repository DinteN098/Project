import java.util.*;

public class Report {
    public static void displayReport() {
        String query = "SELECT * FROM employees";
        List<Map<String, Object>> employees = DatabaseHelper.executeQuery(query);

        // Print the results in a formatted table-like structure
        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-20s\n", "EmpID", "First Name", "Last Name", "Salary",
                "Email", "Hire Date");
        System.out.println("------------------------------------------------------------------------------------");

        for (Map<String, Object> row : employees) {
            System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s\n",
                    row.get("empid"), // EmpID
                    row.get("Fname"), // First Name
                    row.get("Lname"), // Last Name
                    row.get("Salary"), // Salary
                    row.get("email"), // Email
                    row.get("HireDate") // Hire Date
            );
        }

    }
}
