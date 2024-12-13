import java.sql.*;

public class PayrollReport {

    // Method to calculate total pay for a month by job title
    public static void totalPayByJobTitle(String month) {
        String query = "SELECT jt.job_title, SUM(p.earnings) AS total_pay " +
                "FROM payroll p " +
                "JOIN employee_job_titles ejt ON p.empid = ejt.empid " +
                "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                "WHERE DATE_FORMAT(p.pay_date, '%Y-%m') = ? " +
                "GROUP BY jt.job_title";

        try (Connection conn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, month); // Set the month (format: YYYY-MM)
            ResultSet resultSet = stmt.executeQuery();

            System.out.println("Total Pay for Month by Job Title:");
            System.out.printf("%-30s %-15s\n", "Job Title", "Total Pay");
            System.out.println("----------------------------------------------");

            while (resultSet.next()) {
                System.out.printf("%-30s %-15.2f\n",
                        resultSet.getString("job_title"),
                        resultSet.getDouble("total_pay"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while calculating total pay by job title.");
        }
    }

    // Method to calculate total pay for a month by division

    public static void totalPayByDivision(String month) {
        String query = "SELECT d.Name, SUM(p.earnings) AS total_pay " + // Use 'Name' instead of 'division_name'
                "FROM payroll p " +
                "JOIN employee_division ed ON p.empid = ed.empid " +
                "JOIN division d ON ed.div_id = d.ID " + // Correct div_id reference
                "WHERE DATE_FORMAT(p.pay_date, '%Y-%m') = ? " +
                "GROUP BY d.Name"; // Group by 'Name'

        try (Connection conn = DriverManager.getConnection(DatabaseHelper.getUrl(), DatabaseHelper.getUser(),
                DatabaseHelper.getPassword());
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, month); // Set the month (format: YYYY-MM)
            ResultSet resultSet = stmt.executeQuery();

            System.out.println("Total Pay for Month by Division:");
            System.out.printf("%-30s %-15s\n", "Division Name", "Total Pay");
            System.out.println("----------------------------------------------");

            while (resultSet.next()) {
                System.out.printf("%-30s %-15.2f\n",
                        resultSet.getString("Name"), // Access the 'Name' column
                        resultSet.getDouble("total_pay"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while calculating total pay by division.");
        }
    }

    public static void main(String[] args) {
        // Example usage
        String month = "2023-01"; // Specify the month in YYYY-MM format

        totalPayByJobTitle(month);
        System.out.println(); // Blank line for readability
        totalPayByDivision(month);
    }
}
