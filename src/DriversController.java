import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Driver;
import entities.Supplier;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
/**
 * Controller class for drivers view. Creates the view and fills it with necessary data.
 */
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
    private JFXComboBox<String> selectSupplierComboBox;


    @FXML
    private JFXButton addDriverButton;
    @FXML
    private JFXButton deleteRowButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapDriverEntityToTableView();
        refillDriversTableView();
        initSupplierComboBox();
        initAddDriverButton();
        initDeleteRowButton();
    }

    /**
     * Initializes add driver button with logic responsible for adding object to database.
     */
    private void initAddDriverButton() {
        addDriverButton.setOnAction(event -> {
            try {
                double age = Double.parseDouble(value1TextField.getText());
                double theftChance = Double.parseDouble(value2TextField.getText());
                String name = nameTextField.getText();

                if(age < 0 || theftChance < 0)
                    throw new NumberFormatException();
                if(name.isEmpty())
                    throw new NoSuchElementException();

                String selectedSupplierName = selectSupplierComboBox.getSelectionModel().getSelectedItem();
                Supplier selectedSupplier = Database.getSupplierByName(selectedSupplierName);

                Database.addDriver(new Driver(Database.DRIVERS_INDEX,
                        name, age, theftChance, selectedSupplier.getName(), selectedSupplier.getId()));
                nameTextField.setText("");
                value1TextField.setText("");
                value2TextField.setText("");
                selectSupplierComboBox.getSelectionModel().clearSelection();
                refillDriversTableView();
            } catch (NumberFormatException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Age and theft chance should be positive numeric values!")
                        .position(Pos.CENTER)
                        .showError();
            } catch (NullPointerException | NoSuchElementException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Provide both driver name and supplier!")
                        .position(Pos.CENTER)
                        .showError();
            }
        });
    }

    /**
     * Initializes delete row button with logic responsible for removing object from database.
     */
    private void initDeleteRowButton() {
        deleteRowButton.setOnAction(event -> {
            try {
                Driver selection = driversTable.getSelectionModel().getSelectedItem();
                driversTable.getItems().remove(selection);
                Database.removeDriver(selection);
            } catch (Exception ex) {
                Notifications.create()
                        .title("Error")
                        .text("Unexpected error during deletion process!")
                        .position(Pos.CENTER)
                        .showError();
            }
        });
    }

    /**
     * Maps database entity into table view.
     */
    private void mapDriverEntityToTableView() {
        driversIdColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("id"));
        driversNameColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        driversValue1Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("age"));
        driversValue2Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("theftChance"));
        driversSupplierColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("supplierName"));
    }

    /**
     * Fills combobox with suppliers names values from database.
     */
    private void initSupplierComboBox() {
        List<Supplier> suppliers = Database.getSuppliers();
        List<String> suppliersNames = suppliers.stream().map(Supplier::getName).collect(Collectors.toList());
        selectSupplierComboBox.setItems(FXCollections.observableArrayList(suppliersNames));
    }

    /**
     * Reloads the data in table view.
     */
    private void refillDriversTableView() {
        driversTable.setItems(Database.getDrivers());
    }
}
