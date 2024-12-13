import java.sql.*;

public class UpdateSalary {
    public static void bySSN(Double salary, String ssn) {
        String query = "UPDATE employees SET Salary = ? WHERE SSN = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setDouble(1, salary); // Set the salary
            stmt.setString(2, ssn); // Set the SSN

            int rowsAffected = stmt.executeUpdate(); // Execute the update
            System.out.println("Rows affected: " + rowsAffected); // Optionally print the number of rows updated

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while updating salary.");
        }
    }

    public static void byEmpId(Double salary, int empId) {
        String query = "UPDATE employees SET Salary = ? WHERE empid = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setDouble(1, salary); // Set the salary
            stmt.setInt(2, empId); // Set the SSN

            int rowsAffected = stmt.executeUpdate(); // Execute the update
            System.out.println("Rows affected: " + rowsAffected); // Optionally print the number of rows updated

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while updating salary.");
        }
    }
}
