import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        
        try (
            Connection conn = DatabaseHelper.executeQuery();
            Statement stmt = conn.createStatement(); 
            Result rs = stmt.executeQuery(query)
        ) {
            while(rs.next()){
                Employee emp = new Employee(); 
                emp.setEmpid(rs.getInt("empid"));
                emp.setFname(rs.getString("Fname"));
                emp.setLname(rs.getString("Lname"));
                emp.setEmail(rs.getString("email"));
                emp.setHireDate(rs.getDate("HireDate"));
                emp.setSalary(rs.getDouble("Salary"));
                emp.setSSN(rs.getString("SSN"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;

        public static void addEmployee(Employee emp){

            String query = "INSERT INTO employee (Fname, Lname, email, HireDate, Salary, SSN) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, emp.getFname());
                pstmt.setString(2, emp.getLname());
                pstmt.setString(3, emp.getEmail());
                pstmt.setDate(4, emp.getHireDate());
                pstmt.setDouble(5, emp.getSalary());
                pstmt.setString(6, emp.getSSN());
                pstmt.executeUpdate();
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
    }
    
}
