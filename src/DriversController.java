import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Driver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DriversController extends Controller implements Initializable {
    @FXML
    private TableView<Driver> driversTable;

    @FXML
    private TableColumn driversIdColumn;
    @FXML
    private TableColumn driversNameColumn;
    @FXML
    private TableColumn driversValue1Column;
    @FXML
    private TableColumn driversValue2Column;
    @FXML
    private TableColumn driversSupplierColumn;

    @FXML
    private JFXTextField nameTextField;
    @FXML
    private JFXTextField value1TextField;
    @FXML
    private JFXTextField value2TextField;
    @FXML
    private JFXTextField supplierTextField;

    @FXML
    private JFXButton addDriverButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        driversIdColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("id"));
        driversNameColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        driversValue1Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("value1"));
        driversValue2Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("value2"));
        driversSupplierColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("supplier"));
        driversTable.setItems(Database.getDrivers());

        addDriverButton.setOnAction(event -> {
            Database.addDriver(new Driver(Database.getDrivers().size()+1,
                    nameTextField.getText(),
                    Double.parseDouble(value1TextField.getText()),
                    Double.parseDouble(value2TextField.getText()), supplierTextField.getText()));
            nameTextField.setText("");
            value1TextField.setText("");
            value2TextField.setText("");
            supplierTextField.setText("");
            driversTable.setItems(Database.getDrivers());
        });
    }


}
