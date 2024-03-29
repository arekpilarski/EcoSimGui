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
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


/**
 * Controller class for deformations view. Creates the view and fills it with necessary data.
 */
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
    @FXML
    private JFXButton deleteRowButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapDeformationEntityToTableView();
        refillDeformationsTableView();
        initSelectTankComboBox();
        initAddDeformationButton();
        initDeleteRowButton();
    }

    /**
     * Initializes add deformation button with logic responsible for adding object to database.
     */
    private void initAddDeformationButton() {
        addDeformationButton.setOnAction(event -> {
            try {
                Database.addDeformation(new Deformation(Database.DEFORMATIONS_INDEX,
                        Double.parseDouble(value1TextField.getText()),
                        Double.parseDouble(value2TextField.getText()),
                        selectTankComboBox.getSelectionModel().getSelectedItem()));
                clearUserInput();
                refillDeformationsTableView();
            } catch (NumberFormatException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Height and Value should be numeric values!")
                        .position(Pos.CENTER)
                        .showError();
            } catch (NullPointerException exc) {
                Notifications.create()
                        .title("Error")
                        .text("No tank id has been selected!")
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
                Deformation selection = deformationsTable.getSelectionModel().getSelectedItem();
                deformationsTable.getItems().remove(selection);
                Database.removeDeformation(selection);
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
    private void mapDeformationEntityToTableView() {
        deformationsIdColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("id"));
        deformationsValue1Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("height"));
        deformationsValue2Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("value"));
        deformationsTankColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("tankId"));
    }

    /**
     * Fills combobox with tank id values from database.
     */
    private void initSelectTankComboBox() {
        List<Tank> tanks = Database.tanks;
        List<Long> tanksIds = tanks.stream().map(Tank::getId).collect(Collectors.toList());
        selectTankComboBox.setItems(FXCollections.observableArrayList(tanksIds));
    }

    /**
     * Reloads the data in table view.
     */
    private void refillDeformationsTableView() {
        deformationsTable.setItems(Database.getDeformations());
    }


    /**
     * Clears user input.
     */
    private void clearUserInput() {
        value1TextField.setText("");
        value2TextField.setText("");
        selectTankComboBox.getSelectionModel().clearSelection();
    }





}
