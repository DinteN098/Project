import java.sql.*;
import java.util.*;

public class DatabaseHelper {
    private static String url = "jdbc:mysql://localhost:3306/employeeData";
    private static String user = "root";
    private static String password = "password00"; // This field is private but can be accessed through a getter

    // Utility method to execute the query and return results as a list of maps
    public static List<Map<String, Object>> executeQuery(String query) {
        List<Map<String, Object>> results = new ArrayList<>();

        try (Connection myConn = DriverManager.getConnection(url, user, getPassword());
                Statement myStmt = myConn.createStatement();
                ResultSet resultSet = myStmt.executeQuery(query)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = resultSet.getObject(i);
                    row.put(columnName, value);
                }
                results.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password; // Public getter for password
    }
}
