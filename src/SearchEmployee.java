import java.sql.*;

public class SearchEmployee {
    public static void byFirstName(String firstName) {
        String query = "SELECT * FROM employees WHERE Fname = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, firstName); // Set the SSN parameter
            ResultSet resultSet = stmt.executeQuery();

            // Print the results in a formatted table-like structure
            System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s\n", "EmpID", "First Name", "Last Name", "Email",
                    "Hire Date", "Salary");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            while (resultSet.next()) {
                // Print the result set in a formatted table row
                System.out.printf("%-10s %-20s %-15s %-20s %-15s %-15s\n",
                        resultSet.getString("empid"),
                        resultSet.getString("Fname"),
                        resultSet.getString("Lname"),
                        resultSet.getString("email"),
                        resultSet.getString("HireDate"),
                        resultSet.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    public static void byLastName(String lastName) {
        String query = "SELECT * FROM employees WHERE Lname = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, lastName); // Set the SSN parameter
            ResultSet resultSet = stmt.executeQuery();

            // Print the results in a formatted table-like structure
            System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s\n", "EmpID", "First Name", "Last Name", "Email",
                    "Hire Date", "Salary");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            while (resultSet.next()) {
                // Print the result set in a formatted table row
                System.out.printf("%-10s %-20s %-15s %-20s %-15s %-15s\n",
                        resultSet.getString("empid"),
                        resultSet.getString("Fname"),
                        resultSet.getString("Lname"),
                        resultSet.getString("email"),
                        resultSet.getString("HireDate"),
                        resultSet.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    public static void byEmpId(int empId) {
        String query = "SELECT * FROM employees WHERE empid = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setInt(1, empId); // Set the SSN parameter
            ResultSet resultSet = stmt.executeQuery();

            // Print the results in a formatted table-like structure
            System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s\n", "EmpID", "First Name", "Last Name", "Email",
                    "Hire Date", "Salary");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            while (resultSet.next()) {
                // Print the result set in a formatted table row
                System.out.printf("%-10s %-20s %-15s %-20s %-15s %-15s\n",
                        resultSet.getString("empid"),
                        resultSet.getString("Fname"),
                        resultSet.getString("Lname"),
                        resultSet.getString("email"),
                        resultSet.getString("HireDate"),
                        resultSet.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    public static void bySSN(String ssn) {
        String query = "SELECT * FROM employees WHERE SSN = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, ssn); // Set the SSN parameter
            ResultSet resultSet = stmt.executeQuery();

            // Print the results in a formatted table-like structure
            System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s\n", "EmpID", "First Name", "Last Name", "Email",
                    "Hire Date", "Salary");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            while (resultSet.next()) {
                // Print the result set in a formatted table row
                System.out.printf("%-10s %-20s %-15s %-20s %-15s %-15s\n",
                        resultSet.getString("empid"),
                        resultSet.getString("Fname"),
                        resultSet.getString("Lname"),
                        resultSet.getString("email"),
                        resultSet.getString("HireDate"),
                        resultSet.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

}
