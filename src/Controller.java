import javafx.event.ActionEvent;

public class Controller {

    public void moveToTanks(ActionEvent event) throws Exception {
        Main.replaceSceneContent("tanks.fxml");
    }

    public void moveToStations(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stations.fxml");
    }

    public void moveToSuppliers(ActionEvent event) throws Exception {
        Main.replaceSceneContent("suppliers.fxml");
    }

    public void moveToDrivers(ActionEvent event) throws Exception {
        Main.replaceSceneContent("drivers.fxml");
    }

    public void moveToSimulation(ActionEvent event) throws Exception {
        Main.replaceSceneContent("simulation.fxml");
    }

    public void moveToDeformations(ActionEvent event) throws Exception {
        Main.replaceSceneContent("deformations.fxml");
    }
}

