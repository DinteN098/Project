import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeUpdate {

    // Method to get an employee based on the chosen identifier
    public static Employee getEmployeeForUpdate(int empId) {
        return SearchEmployee.byEmpId(empId); // Fetch employee by Employee ID
    }

    // Method to update an employee's details
    public static void updateEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose identifier for employee to update:");
        System.out.println("1. Employee ID");
        System.out.println("2. SSN");
        System.out.println("3. First Name");
        System.out.println("4. Last Name");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Employee employeeToUpdate = null;

        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                int empId = scanner.nextInt();
                employeeToUpdate = SearchEmployee.byEmpId(empId);
                break;

            case 2:
                System.out.print("Enter SSN: ");
                String ssn = scanner.nextLine();
                employeeToUpdate = SearchEmployee.bySSN(ssn);
                break;

            case 3:
                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine();
                employeeToUpdate = SearchEmployee.byFirstName(firstName);
                break;

            case 4:
                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();
                employeeToUpdate = SearchEmployee.byLastName(lastName); // Add a search method for last name
                break;

            default:
                System.out.println("Invalid choice. Exiting update process.");
                return;
        }

        if (employeeToUpdate != null) {
            System.out.println("Employee found: " + employeeToUpdate);

            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();

            System.out.print("Enter new salary: ");
            double newSalary = scanner.nextDouble();
            scanner.nextLine(); // consumes the newline

            System.out.print("Enter new last name (leave empty if no change): ");
            String newLastName = scanner.nextLine();

            // Update details in employee object if changes were provided
            employeeToUpdate.setEmail(newEmail);
            employeeToUpdate.setSalary(newSalary);
            if (!newLastName.isEmpty()) {
                employeeToUpdate.setLname(newLastName); // Update last name if provided
            }

            if (saveEmployeeUpdate(employeeToUpdate)) {
                System.out.println("Employee details updated successfully!");
            } else {
                System.out.println("Error updating employee details.");
            }
        } else {
            System.out.println("No employee found with the provided identifier.");
        }
    }

    // Method to save the updated employee details to the database
    private static boolean saveEmployeeUpdate(Employee employee) {
        // Don't include empId in the update query, as empId should never be updated
        String query = "UPDATE employees SET email = ?, salary = ?, lname = ? WHERE empid = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData", "root",
                "10312018"); // Directly using the connection here
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getEmail());
            stmt.setDouble(2, employee.getSalary());
            stmt.setString(3, employee.getLname()); // Set the last name in the update query
            stmt.setInt(4, employee.getEmpId()); // The empId is used only for filtering, not for update

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error saving updated employee: " + e.getMessage());
            return false;
        }
    }
}
