import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import entities.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
/**
 * Controller class for suppliers view. Creates the view and fills it with necessary data.
 */
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
    @FXML
    private JFXButton deleteRowButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapSupplierEntityToTableView();
        refillSuppliersTableView();
        initAddSupplierButton();
        initDeleteRowButton();
    }

    /**
     * Initializes add supplier button with logic responsible for adding object to database.
     */
    private void initAddSupplierButton() {
        addSupplierButton.setOnAction(event -> {
            try {
                double theftChance = Double.parseDouble(value1TextField.getText());
                String name = nameTextField.getText();
                if(theftChance < 0)
                    throw new NumberFormatException();
                if (name.isEmpty())
                    throw new NoSuchElementException();

                Database.addSupplier(new Supplier(Database.SUPPLIERS_INDEX,
                        name, theftChance));

                clearInput();
                refillSuppliersTableView();
            } catch (NumberFormatException exc) {
                Notifications.create()
                        .title("Error")
                        .text("Theft chance numeric value should be positive!")
                        .position(Pos.CENTER)
                        .showError();
            } catch (NoSuchElementException exc) {
                Notifications.create()
                        .title("Error")
                        .text("No name has been provided!")
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
                Supplier selection = suppliersTable.getSelectionModel().getSelectedItem();
                suppliersTable.getItems().remove(selection);
                Database.removeSupplier(selection);
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
    private void mapSupplierEntityToTableView() {
        suppliersIdColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("id"));
        suppliersNameColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("name"));
        suppliersValue1Column.setCellValueFactory(new PropertyValueFactory<Supplier,String>("theftChance"));
    }

    /**
     * Reloads the data in table view.
     */
    private void refillSuppliersTableView() {
        suppliersTable.setItems(Database.getSuppliers());
    }

    /**
     * Clears user input.
     */
    private void clearInput() {
        nameTextField.setText("");
        value1TextField.setText("");
    }
}
