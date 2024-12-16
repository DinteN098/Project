import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


import java.sql.*;

public class Main extends Application {
    private static final String DATABASE = "employeeData";
     // The parent layout manager
    private final BorderPane parent = new BorderPane();

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource.("GUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Employee Records Management");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
    }
    private void buildUI() {

        // Create the TableView
        TableView<User> tableView = this.createTableView();

        // Create a DBConnection instance for the specified database
        DBConnection dbConnection = new DBConnection(DATABASE);

        // Populate the TableView with data from the database
        populateTableView(dbConnection, tableView);

        // Set the ProgressIndicator as the center content of the BorderPane
        parent.setCenter(new ProgressIndicator());
    }
    private TableView<User> createTableView() {

        // Create the TableView
        TableView<User> tableView = new TableView<>();

        // Create columns for the TableView
        TableColumn<User, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<User, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<User, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        // Add columns to the TableView
        tableView.getColumns().addAll(idColumn, nameColumn, ageColumn, emailColumn, phoneNumberColumn);

        return tableView;
    }

    public static void main(String[] args) {
        launch(args);
    }

}