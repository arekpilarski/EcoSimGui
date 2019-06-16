import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Deformation;
import entities.Driver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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
    private JFXTextField tankTextField;

    @FXML
    private JFXButton addDeformationButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deformationsIdColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("id"));
        deformationsValue1Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("value1"));
        deformationsValue2Column.setCellValueFactory(new PropertyValueFactory<Driver,String>("value2"));
        deformationsTankColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("tank"));
        deformationsTable.setItems(Database.getDeformations());

        addDeformationButton.setOnAction(event -> {
            Database.addDeformation(new Deformation(Database.getDeformations().size()+1,
                    Double.parseDouble(value1TextField.getText()),
                    Double.parseDouble(value2TextField.getText()),
                    Long.parseLong(tankTextField.getText())));
            value1TextField.setText("");
            value2TextField.setText("");
            tankTextField.setText("");
            deformationsTable.setItems(Database.getDeformations());
        });
    }
}
