import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Station;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableColumn stationsValue3Column;


    @FXML
    private JFXTextField nameTextField;
    @FXML
    private JFXTextField value1TextField;
    @FXML
    private JFXTextField value2TextField;
    @FXML
    private JFXTextField value3TextField;
    @FXML
    private JFXButton addStationButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stationsIdColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("id"));
        stationsNameColumn.setCellValueFactory(new PropertyValueFactory<Station,String>("name"));
        stationsValue1Column.setCellValueFactory(new PropertyValueFactory<Station,String>("value1"));
        stationsValue2Column.setCellValueFactory(new PropertyValueFactory<Station,String>("value2"));
        stationsValue3Column.setCellValueFactory(new PropertyValueFactory<Station,String>("value3"));
        stationsTable.setItems(Database.getStations());

        addStationButton.setOnAction(event -> {
            Database.addStation(new Station(Database.getStations().size()+1,
                    nameTextField.getText(),
                    Double.parseDouble(value1TextField.getText()),
                    Double.parseDouble(value2TextField.getText()),
                    Double.parseDouble(value3TextField.getText())));
            nameTextField.setText("");
            value1TextField.setText("");
            value2TextField.setText("");
            value3TextField.setText("");
            stationsTable.setItems(Database.getStations());
        });
    }
}
