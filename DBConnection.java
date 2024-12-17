import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String database = "employeeData";
    private String username = "root";
    private String password = "password00";
    private String url = "jdbc:mysql://localhos/" + database;

    // Constructor with only database name, using default username and empty password
    public DBConnection(String database) {
        this.init(database, "root", "", "localhost", "3306");
    }

    // Constructor with database name and custom username, using empty password
    public DBConnection(String database, String username) {
        this.init(database, username, "", "localhost", "3306");
    }

    // Constructor with database name, custom username, and custom password
    public DBConnection(String database, String username, String password) {
        this.init(database, username, password, "localhost", "3306");
    }

    // Constructor with database name, custom username, custom password, and custom host
    public DBConnection(String database, String username, String password, String host) {
        this.init(database, username, password, host, "3306");
    }

    // Constructor with database name, custom username, custom password, custom host, and custom port
    public DBConnection(String database, String username, String password, String host, String port) {
        this.init(database, username, password, host, port);
    }

    // Initialize the database connection parameters
    private void init(String database, String username, String password, String host, String port) {

        // Construct the JDBC URL for the MySQL database
        this.url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);
        this.username = username;
        this.password = password;
    }

    // Get the underlying Connection object for database operations
    public Connection getConnection() throws SQLException {

        // Attempt to establish the database connection using DriverManager
        return DriverManager.getConnection(this.url, username, password);
    }
}