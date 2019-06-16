import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Station;
import entities.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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
        stationsIdColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("id"));
        stationsNameColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("name"));
        stationsValue1Column.setCellValueFactory(new PropertyValueFactory<Station,String>("fuelSalesFactor"));
        stationsValue2Column.setCellValueFactory(new PropertyValueFactory<Station,String>("climateOffset"));
        stationsSuppliersColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("supplierNames"));
        stationsTable.setItems(Database.getStations());

        suppliersNameColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("name"));
        suppliersTheftChanceColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("theftChance"));
        suppliersTableView.setItems(Database.getSuppliers());
        suppliersTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        addStationButton.setOnAction(event -> {
            Database.addStation(new Station(Database.getStations().size()+1,
                    nameTextField.getText(),
                    Double.parseDouble(value1TextField.getText()),
                    Double.parseDouble(value2TextField.getText()),
                    suppliersTableView.getSelectionModel().getSelectedItems()));
            nameTextField.setText("");
            value1TextField.setText("");
            value2TextField.setText("");
            suppliersTableView.getSelectionModel().clearSelection();


            stationsTable.setItems(Database.getStations());
        });

        deleteRowButton.setOnAction(event -> {
            try {
                Station selection = stationsTable.getSelectionModel().getSelectedItem();
                stationsTable.getItems().remove(selection);
                Database.removeStation(selection);
            } catch (Exception ex) {}
        });
    }
}
