import javafx.event.ActionEvent;

/**
 * Base controller class responsible for switching views.
 */
public class Controller {

    /**
     * Switch to tanks view.
     * @param event mouse click event
     * @throws Exception
     */
    public void moveToTanks(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/tanks.fxml");
    }

    /**
     * Switch to stations view.
     * @param event mouse click event
     * @throws Exception
     */
    public void moveToStations(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/stations.fxml");
    }

    /**
     * Switch to suppliers view.
     * @param event mouse click event
     * @throws Exception
     */
    public void moveToSuppliers(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/suppliers.fxml");
    }

    /**
     * Switch to drivers view.
     * @param event mouse click event
     * @throws Exception
     */
    public void moveToDrivers(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/drivers.fxml");
    }

    /**
     * Switch to simulation view.
     * @param event mouse click event
     * @throws Exception
     */
    public void moveToSimulation(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/simulation.fxml");
    }

    /**
     * Switch to deformations view.
     * @param event mouse click event
     * @throws Exception
     */
    public void moveToDeformations(ActionEvent event) throws Exception {
        Main.replaceSceneContent("stages/deformations.fxml");
    }
}

