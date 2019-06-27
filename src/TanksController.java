import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Station;
import entities.Tank;
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
 * Controller class for tanks view. Creates the view and fills it with necessary data.
 */
public class TanksController extends Controller implements Initializable {
    @FXML
    private TableView<Tank> tanksTable;

    @FXML
    private TableColumn tanksIdColumn;
    @FXML
    private TableColumn tanksValue1Column;
    @FXML
    private TableColumn tanksValue2Column;
    @FXML
    private TableColumn tanksValue3Column;
    @FXML
    private TableColumn tanksValue4Column;
    @FXML
    private TableColumn tanksValue5Column;
    @FXML
    private TableColumn tanksStationColumn;

    @FXML
    private JFXTextField value1TextField;
    @FXML
    private JFXTextField value2TextField;
    @FXML
    private JFXTextField value3TextField;
    @FXML
    private JFXTextField value4TextField;
    @FXML
    private JFXTextField value5TextField;
    @FXML
    private JFXComboBox<String> stationsNamesComboBox;
    @FXML
    private JFXButton addTankButton;
    @FXML
    private JFXButton deleteRowButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapTankEntityToTableView();
        refillTanksTableView();
        initStationsComboBox();
        initAddTankButton();
        initDeleteRowButton();
    }

    /**
     * Initializes add tank button with logic responsible for adding object to database.
     */
    private void initAddTankButton() {
        addTankButton.setOnAction(event -> {
            try {
                double initialFillFactor = Double.parseDouble(value1TextField.getText());
                double radius = Double.parseDouble(value2TextField.getText());
                double height = Double.parseDouble(value3TextField.getText());
                double thickness = Double.parseDouble(value4TextField.getText());
                double leakChance = Double.parseDouble(value5TextField.getText());
                if(initialFillFactor < 0 || radius < 0 || height < 0 || thickness < 0 || leakChance < 0)
                    throw new NumberFormatException();

                String selectedStationName = stationsNamesComboBox.getSelectionModel().getSelectedItem();
                Station selectedStation = Database.getStationByName(selectedStationName);

                Database.addTank(new Tank(Database.TANKS_INDEX,
                        initialFillFactor, radius, height, thickness, leakChance,
                        selectedStation.getId(), selectedStation.getName()));
                clearInput();
                refillTanksTableView();
            } catch (NumberFormatException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Numeric values should be positive!")
                        .position(Pos.CENTER)
                        .showError();
            } catch (NullPointerException | NoSuchElementException exc) {
                Notifications.create()
                        .title("Error")
                        .text("No station has been selected!")
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
                Tank selection = tanksTable.getSelectionModel().getSelectedItem();
                tanksTable.getItems().remove(selection);
                Database.removeTank(selection);
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
    private void mapTankEntityToTableView() {
        tanksIdColumn.setCellValueFactory(new PropertyValueFactory<Tank,String>("id"));
        tanksValue1Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("initialFillFactor"));
        tanksValue2Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("tankRadius"));
        tanksValue3Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("tankHeight"));
        tanksValue4Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("tankThickness"));
        tanksValue5Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("leakChance"));
        tanksStationColumn.setCellValueFactory(new PropertyValueFactory<Tank,String>("stationName"));
    }

    /**
     * Fills combobox with stations names values from database.
     */
    private void initStationsComboBox() {
        List<Station> stations = Database.getStations();
        List<String> stationsNames = stations.stream().map(Station::getName).collect(Collectors.toList());
        stationsNamesComboBox.setItems(FXCollections.observableArrayList(stationsNames));
    }

    /**
     * Reloads the data in table view.
     */
    private void refillTanksTableView() {
        tanksTable.setItems(Database.getTanks());
    }


    /**
     * Clears user input.
     */
    private void clearInput() {
        value1TextField.setText("");
        value2TextField.setText("");
        value3TextField.setText("");
        value4TextField.setText("");
        value5TextField.setText("");
    }
}
