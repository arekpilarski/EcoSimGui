import entities.Deformation;
import entities.Station;
import entities.Supplier;
import entities.Tank;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Driver;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        setUpStage(primaryStage);
        replaceSceneContent("suppliers.fxml");
        currentStage.show();
    }

    private void setUpStage(Stage stage) {
        currentStage = stage;
        currentStage.setTitle("EcoSim");
    }
    public static void main(String[] args) {
        // TEST TEST TEST TEST TEST
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier(0, "Good petrol", 0.1));

        List<entities.Driver> drivers = new ArrayList<>();
        drivers.add(new entities.Driver(0, "Arnold", 20, 0.01, "Good petrol", 0));

        List<Station> stations = new ArrayList<>();
        stations.add(new Station(0, "Bipi", 0.1, 0, suppliers));

        List<Tank> tanks = new ArrayList<>();
        tanks.add(new Tank(0, 10, 5, 0.01, 0.5, 0.001, 0,"Bipi"));

        List<Deformation> deformations = new ArrayList<>();
        deformations.add(new Deformation(0, 0.1, 0.1, 0));

        //Driver.run(deformations, drivers, stations, suppliers, tanks);
        // End test
        
        launch(args);
    }

    public static Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = currentStage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            currentStage.setScene(scene);
        } else {
            currentStage.getScene().setRoot(page);
        }
        currentStage.sizeToScene();
        return page;
    }
}
