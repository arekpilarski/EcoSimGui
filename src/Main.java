
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Main class of the application.
 */
public class Main extends Application {

    /**
     * Current view.
     */
    static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        setUpStage(primaryStage);
        replaceSceneContent("stages/suppliers.fxml");
        currentStage.show();
    }

    /**
     * Sets up application window.
     */
    private void setUpStage(Stage stage) {
        currentStage = stage;
        currentStage.setTitle("EcoSim");
        currentStage.setResizable(false);
        currentStage.setFullScreen(false);
    }
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Updates application window view.
     */
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
