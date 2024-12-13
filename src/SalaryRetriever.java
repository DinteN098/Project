import java.sql.*;

public class SalaryRetriever {

    public static Double bySSN(String ssn) {
        String query = "SELECT Salary FROM employees WHERE SSN = ?";
        Double salary = null;

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setString(1, ssn); // Set the SSN parameter
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                salary = resultSet.getDouble("Salary"); // Retrieve the salary
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while retrieving salary.");
        }

        return salary; // Return the salary
    }

    public static Double byEmpId(int empId) {
        String query = "SELECT Salary FROM employees WHERE empid = ?";
        Double salary = null;

        try (Connection myConn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = myConn.prepareStatement(query)) {

            stmt.setInt(1, empId); // Set the SSN parameter
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                salary = resultSet.getDouble("Salary"); // Retrieve the salary
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while retrieving salary.");
        }

        return salary; // Return the salary
    }
}
