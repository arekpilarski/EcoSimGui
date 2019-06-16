import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SuppliersController extends Controller implements Initializable {
    @FXML
    private TableView<Supplier> suppliersTable;

    @FXML
    private TableColumn suppliersIdColumn;
    @FXML
    private TableColumn suppliersNameColumn;
    @FXML
    private TableColumn suppliersValue1Column;

    @FXML
    private JFXTextField nameTextField;
    @FXML
    private JFXTextField value1TextField;
    @FXML
    private JFXButton addSupplierButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suppliersIdColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("id"));
        suppliersNameColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("name"));
        suppliersValue1Column.setCellValueFactory(new PropertyValueFactory<Supplier,String>("theftChance"));
        suppliersTable.setItems(Database.getSuppliers());

        addSupplierButton.setOnAction(event -> {
            Database.addSupplier(new Supplier(Database.getSuppliers().size()+1,
                    nameTextField.getText(),
                    Double.parseDouble(value1TextField.getText())));
            nameTextField.setText("");
            value1TextField.setText("");
            suppliersTable.setItems(Database.getSuppliers());
        });
    }
}
