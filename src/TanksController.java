import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Station;
import entities.Tank;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
        tanksIdColumn.setCellValueFactory(new PropertyValueFactory<Tank,String>("id"));
        tanksValue1Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("initialFillFactor"));
        tanksValue2Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("tankRadius"));
        tanksValue3Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("tankHeight"));
        tanksValue4Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("tankThickness"));
        tanksValue5Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("leakChance"));
        tanksStationColumn.setCellValueFactory(new PropertyValueFactory<Tank,String>("stationName"));
        tanksTable.setItems(Database.getTanks());

        // Load stations names
        List<Station> stations = Database.getStations();
        List<String> stationsNames = stations.stream().map(Station::getName).collect(Collectors.toList());
        stationsNamesComboBox.setItems(FXCollections.observableArrayList(stationsNames));

        addTankButton.setOnAction(event -> {
            String selectedStationName = stationsNamesComboBox.getSelectionModel().getSelectedItem();
            Station selectedStation = Database.getStationByName(selectedStationName);


            Database.addTank(new Tank(Database.getTanks().size()+1,
                                Double.parseDouble(value1TextField.getText()),
                                Double.parseDouble(value2TextField.getText()),
                                Double.parseDouble(value3TextField.getText()),
                                Double.parseDouble(value4TextField.getText()),
                                Double.parseDouble(value5TextField.getText()),
                                selectedStation.getId(),
                                selectedStation.getName()));
            value1TextField.setText("");
            value2TextField.setText("");
            value3TextField.setText("");
            value4TextField.setText("");
            value5TextField.setText("");
            tanksTable.setItems(Database.getTanks());
        });

        deleteRowButton.setOnAction(event -> {
            try {
                Tank selection = tanksTable.getSelectionModel().getSelectedItem();
                tanksTable.getItems().remove(selection);
                Database.removeTank(selection);
            } catch (Exception ex) {}
        });
    }
}
