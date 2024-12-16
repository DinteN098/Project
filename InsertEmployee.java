import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmployee {

    // Method to insert employee data into the database
    public static void addEmployeeToDatabase(Employee employee) {
        String query = "INSERT INTO employees (first_name, last_name, email, hire_date, salary, ssn) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getFname());
            stmt.setString(2, employee.getLname());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getHireDate());
            stmt.setDouble(5, employee.getSalary());
            stmt.setString(6, employee.getSsn());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee added successfully!");
            } else {
                System.out.println("Error adding employee.");
            }
        } catch (Exception e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    // Method to gather employee input and return an Employee object
    public static Employee getEmployeeFromInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter hire date (YYYY-MM-DD): ");
            String hireDate = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            System.out.print("Enter SSN: ");
            String ssn = scanner.nextLine();

            return new Employee(firstName, lastName, email, hireDate, salary, ssn);
        } catch (Exception e) {
            System.err.println("Error during input: " + e.getMessage());
            return null;
        }
    }
}
