import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Tank;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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
    private JFXTextField stationTextField;
    @FXML
    private JFXButton addTankButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tanksIdColumn.setCellValueFactory(new PropertyValueFactory<Tank,String>("id"));
        tanksValue1Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("value1"));
        tanksValue2Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("value2"));
        tanksValue3Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("value3"));
        tanksValue4Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("value4"));
        tanksValue5Column.setCellValueFactory(new PropertyValueFactory<Tank,String>("value5"));
        tanksStationColumn.setCellValueFactory(new PropertyValueFactory<Tank,String>("station"));
        tanksTable.setItems(Database.getTanks());

        addTankButton.setOnAction(event -> {
            Database.addTank(new Tank(Database.getTanks().size()+1,
                    Double.parseDouble(value1TextField.getText()),
                    Double.parseDouble(value2TextField.getText()),
                    Double.parseDouble(value3TextField.getText()),
                    Double.parseDouble(value4TextField.getText()),
                    Double.parseDouble(value5TextField.getText()),
                    Long.parseLong(stationTextField.getText())));
            value1TextField.setText("");
            value2TextField.setText("");
            value3TextField.setText("");
            value4TextField.setText("");
            value5TextField.setText("");
            tanksTable.setItems(Database.getTanks());
        });
    }
}
