import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;
import logic.Driver;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SimulationController extends Controller implements Initializable {

    @FXML
    private JFXTextField outputDirectoryTextField;
    @FXML
    private JFXButton browseButton;
    @FXML
    private JFXButton runSimulationButton;

    private DirectoryChooser directoryChooser;
    private File selectedDirectory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose output directory");

        browseButton.setOnAction(event -> {
            selectedDirectory = directoryChooser.showDialog(Main.currentStage);
            outputDirectoryTextField.setText(selectedDirectory.getAbsolutePath());
        });

        runSimulationButton.setOnAction(event -> {
            Driver.run(Database.getDeformations(), Database.getDrivers(), Database.getStations(),
                    Database.getSuppliers(), Database.getTanks(), outputDirectoryTextField.getText());
        });
    }
}
