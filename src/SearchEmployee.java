import java.sql.*;

public class SearchEmployee {

    // Search by first name
    public static Employee byFirstName(String firstName) {
        String query = "SELECT * FROM employees WHERE Fname = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, firstName);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToEmployee(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }

        return null; // Return null if no employee is found
    }

    // Search by last name
    public static Employee byLastName(String lastName) {
        String query = "SELECT * FROM employees WHERE Lname = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, lastName);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToEmployee(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }

        return null; // Return null if no employee is found
    }

    // Search by employee ID
    public static Employee byEmpId(int empId) {
        String query = "SELECT * FROM employees WHERE empid = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Fetch employee details
                Employee employee = mapResultSetToEmployee(resultSet);

                // Fetch and print payment history
                printPaymentHistory(myConn, empId);

                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }

        return null; // Return null if no employee is found
    }

    // Search by SSN
    public static Employee bySSN(String ssn) {
        String query = "SELECT * FROM employees WHERE SSN = ?";

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, ssn);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToEmployee(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while searching for employee.");
        }

        return null; // Return null if no employee is found
    }

    // Helper method to map ResultSet to Employee object
    private static Employee mapResultSetToEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                resultSet.getInt("empid"),
                resultSet.getString("Fname"),
                resultSet.getString("Lname"),
                resultSet.getString("email"),
                resultSet.getString("HireDate"),
                resultSet.getDouble("Salary"),
                resultSet.getString("SSN"));
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
