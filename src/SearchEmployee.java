import java.sql.*;

public class SearchEmployee {

    // Search by first name
    public static void byFirstName(String firstName) {
        String query = "SELECT * FROM employees WHERE Fname = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, firstName);
            ResultSet resultSet = stmt.executeQuery();

            // Print employee details
            printEmployeeDetails(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    // Search by last name
    public static void byLastName(String lastName) {
        String query = "SELECT * FROM employees WHERE Lname = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, lastName);
            ResultSet resultSet = stmt.executeQuery();

            // Print employee details
            printEmployeeDetails(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    // Search by employee ID
    public static void byEmpId(int empId) {
        String query = "SELECT * FROM employees WHERE empid = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            ResultSet resultSet = stmt.executeQuery();

            // Print employee details
            printEmployeeDetails(resultSet);

            // Fetch and print payment history
            printPaymentHistory(myConn, empId);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    // Search by SSN
    public static void bySSN(String ssn) {
        String query = "SELECT * FROM employees WHERE SSN = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, ssn);
            ResultSet resultSet = stmt.executeQuery();

            // Print employee details
            printEmployeeDetails(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }
    }

    // Helper method to print employee details
    private static void printEmployeeDetails(ResultSet resultSet) throws SQLException {
        System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s\n", "EmpID", "First Name", "Last Name", "Email",
                "Hire Date", "Salary");
        System.out.println(
                "-----------------------------------------------------------------------------------------------");

        while (resultSet.next()) {
            System.out.printf("%-10s %-20s %-15s %-20s %-15s %-15s\n",
                    resultSet.getString("empid"),
                    resultSet.getString("Fname"),
                    resultSet.getString("Lname"),
                    resultSet.getString("email"),
                    resultSet.getString("HireDate"),
                    resultSet.getString("Salary"));
        }
    }

    // Helper method to fetch and print payment history
    private static void printPaymentHistory(Connection conn, int empId) throws SQLException {
        String query = "SELECT * FROM payroll WHERE empid = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, empId);
            ResultSet resultSet = stmt.executeQuery();

            System.out.println("\nPayment History:");
            System.out.printf("%-10s %-15s %-10s %-10s %-10s %-10s %-10s\n", "PayID", "Pay Date", "Earnings",
                    "Fed Tax", "State Tax", "401k", "Health Care");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            while (resultSet.next()) {
                System.out.printf("%-10s %-15s %-10s %-10s %-10s %-10s %-10s\n",
                        resultSet.getInt("payID"),
                        resultSet.getDate("pay_date"),
                        resultSet.getBigDecimal("earnings"),
                        resultSet.getBigDecimal("fed_tax"),
                        resultSet.getBigDecimal("state_tax"),
                        resultSet.getBigDecimal("retire_401k"),
                        resultSet.getBigDecimal("health_care"));
            }
        }
    }
}
