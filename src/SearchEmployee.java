import java.util.List;
import java.util.Map;

public class SearchEmployee {

    // Search by Employee ID
    public static Employee byEmpId(int empId) {
        String query = "SELECT * FROM employees WHERE employee_id = " + empId;
        List<Map<String, Object>> results = DatabaseHelper.executeQuery(query);

        if (results.isEmpty()) {
            System.out.println("No employee found with Employee ID: " + empId);
            return null;
        }

        return createEmployeeFromMap(results.get(0));
    }

    // Search by SSN
    public static Employee bySSN(String ssn) {
        String query = "SELECT * FROM employees WHERE ssn = '" + ssn + "'";
        List<Map<String, Object>> results = DatabaseHelper.executeQuery(query);

        if (results.isEmpty()) {
            System.out.println("No employee found with SSN: " + ssn);
            return null;
        }

        return createEmployeeFromMap(results.get(0));
    }

    // Search by First Name
    public static Employee byFirstName(String firstName) {
        String query = "SELECT * FROM employees WHERE first_name = '" + firstName + "'";
        List<Map<String, Object>> results = DatabaseHelper.executeQuery(query);

        if (results.isEmpty()) {
            System.out.println("No employee found with First Name: " + firstName);
            return null;
        }

        return createEmployeeFromMap(results.get(0));
    }

    // Search by Last Name
    public static Employee byLastName(String lastName) {
        String query = "SELECT * FROM employees WHERE last_name = '" + lastName + "'";
        List<Map<String, Object>> results = DatabaseHelper.executeQuery(query);

        if (results.isEmpty()) {
            System.out.println("No employee found with Last Name: " + lastName);
            return null;
        }

        return createEmployeeFromMap(results.get(0));
    }

    // Helper method to create an Employee object from a database row
    private static Employee createEmployeeFromMap(Map<String, Object> row) {
        return new Employee(
            (String) row.get("first_name"),
            (String) row.get("last_name"),
            (String) row.get("email"),
            (String) row.get("hire_date"),
            ((Number) row.get("salary")).doubleValue(),
            (String) row.get("ssn")
        );
    }
}
