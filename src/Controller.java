import java.io.IOException;
import java.sql.*; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, Integer> colEmpId;

    @FXML
    private TableColumn<Employee, String> colFname;

    @FXML
    private TableColumn<Employee, String> colLname;

    @FXML
    private TableColumn<Employee, String> colEmail;

    @FXML
    private TableColumn<Employee, String> colHireDate;

    @FXML
    private TableColumn<Employee, Double> colSalary;

    @FXML
    private TableColumn<Employee, String> colSSN;

    private ObservableList<Employee> employeeList;

    public void connectButton() {
        DBConnection conn = new DBConnection("employeeData", "root", "password00","jdbc:mysql://localhost:3306/employeeData");
        Connection connectDB = conn.getConnection(); 
    }
}
