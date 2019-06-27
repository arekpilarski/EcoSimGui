import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Station;
import entities.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
/**
 * Controller class for stations view. Creates the view and fills it with necessary data.
 */
public class StationsController extends Controller implements Initializable {
    @FXML
    private TableView<Station> stationsTable;
    @FXML
    private TableColumn stationsIdColumn;
    @FXML
    private TableColumn stationsNameColumn;
    @FXML
    private TableColumn stationsValue1Column;
    @FXML
    private TableColumn stationsValue2Column;
    @FXML
    private TableColumn stationsSuppliersColumn;

    @FXML
    private TableView<Supplier> suppliersTableView;
    @FXML
    private TableColumn suppliersNameColumn;
    @FXML
    private TableColumn suppliersTheftChanceColumn;


    @FXML
    private JFXTextField nameTextField;
    @FXML
    private JFXTextField value1TextField;
    @FXML
    private JFXTextField value2TextField;
    @FXML
    private JFXButton addStationButton;
    @FXML
    private JFXButton deleteRowButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapStationsEntityToTableView();
        mapSuppliersEntityToTableView();
        refillStationsTableView();
        prepareSuppliersTableView();
        initAddStationButton();
        initDeleteRowButton();
    }

    /**
     * Loads suppliers data into selection table view.
     */
    private void prepareSuppliersTableView() {
        suppliersTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        suppliersTableView.setItems(Database.getSuppliers());
    }

    /**
     * Maps database entity into table view.
     */
    private void mapSuppliersEntityToTableView() {
        suppliersNameColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("name"));
        suppliersTheftChanceColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("theftChance"));
    }

    /**
     * Reloads the data in table view.
     */
    private void refillStationsTableView() {
        stationsTable.setItems(Database.getStations());
    }

    /**
     * Maps database entity into table view.
     */
    private void mapStationsEntityToTableView() {
        stationsIdColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("id"));
        stationsNameColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("name"));
        stationsValue1Column.setCellValueFactory(new PropertyValueFactory<Station,String>("fuelSalesFactor"));
        stationsValue2Column.setCellValueFactory(new PropertyValueFactory<Station,String>("climateOffset"));
        stationsSuppliersColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("supplierNames"));
    }


    /**
     * Initializes add station button with logic responsible for adding object to database.
     */
    private void initAddStationButton() {
        addStationButton.setOnAction(event -> {

            try {
                double fuelSalesFactor = Double.parseDouble(value1TextField.getText());
                double climateOffset = Double.parseDouble(value2TextField.getText());
                String name = nameTextField.getText();
                List<Supplier> selectedSuppliers = suppliersTableView.getSelectionModel().getSelectedItems();

                if(fuelSalesFactor < 0 || climateOffset < 0)
                    throw new NumberFormatException();
                if(name.isEmpty() || selectedSuppliers.isEmpty())
                    throw new NoSuchElementException();
                Database.addStation(new Station(Database.STATIONS_INDEX,
                        name, fuelSalesFactor, climateOffset, selectedSuppliers));
                clearInput();

                refillStationsTableView();
            } catch (NumberFormatException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Fuel sales factor and climate offset should be positive numeric values!")
                        .position(Pos.CENTER)
                        .showError();
            } catch (NullPointerException | NoSuchElementException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Provide station name and select suppliers.")
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
                Station selection = stationsTable.getSelectionModel().getSelectedItem();
                stationsTable.getItems().remove(selection);
                Database.removeStation(selection);
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
     * Clears user input.
     */
    private void clearInput() {
        nameTextField.setText("");
        value1TextField.setText("");
        value2TextField.setText("");
        suppliersTableView.getSelectionModel().clearSelection();
    }
}
