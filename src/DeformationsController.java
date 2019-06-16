import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Deformation;
import entities.Driver;
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

public class DeformationsController extends Controller implements Initializable {

    @FXML
    private TableView<Deformation> deformationsTable;

    @FXML
    private TableColumn deformationsIdColumn;
    @FXML
    private TableColumn deformationsValue1Column;
    @FXML
    private TableColumn deformationsValue2Column;
    @FXML
    private TableColumn deformationsTankColumn;


    @FXML
    private JFXTextField value1TextField;
    @FXML
    private JFXTextField value2TextField;
    @FXML
    private JFXComboBox<Long> selectTankComboBox;

    @FXML
    private JFXButton addDeformationButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deformationsIdColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("id"));
        deformationsValue1Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("height"));
        deformationsValue2Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("value"));
        deformationsTankColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("tankId"));
        deformationsTable.setItems(Database.getDeformations());

        // Load tank ids
        List<Tank> tanks = Database.tanks;
        List<Long> tanksIds = tanks.stream().map(Tank::getId).collect(Collectors.toList());
        selectTankComboBox.setItems(FXCollections.observableArrayList(tanksIds));

        addDeformationButton.setOnAction(event -> {
            Database.addDeformation(new Deformation(Database.getDeformations().size()+1,
                    Double.parseDouble(value1TextField.getText()),
                    Double.parseDouble(value2TextField.getText()),
                    selectTankComboBox.getSelectionModel().getSelectedItem()));
            value1TextField.setText("");
            value2TextField.setText("");
            selectTankComboBox.getSelectionModel().clearSelection();
            deformationsTable.setItems(Database.getDeformations());
        });
    }
}
