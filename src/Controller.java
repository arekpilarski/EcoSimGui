import javafx.event.ActionEvent;

public class Controller {

    public void moveToTanks(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/tanks.fxml");
    }

    public void moveToStations(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/stations.fxml");
    }

    public void moveToSuppliers(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/suppliers.fxml");
    }

    public void moveToDrivers(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/drivers.fxml");
    }

    public void moveToSimulation(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/simulation.fxml");
    }

    public void moveToDeformations(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/deformations.fxml");
    }
}

