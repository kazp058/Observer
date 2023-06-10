import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class observerController implements  Initializable, ColorChangeObserver{

    @FXML
    private Button botonAzul;

    @FXML
    private Button botonRojo;

    @FXML
    private Button botonVerde;
    @FXML
    private VBox rootPane;
    
    private Stage stage;
    
    private Scene scene;
    
    private ColorAspect aspect;
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	ColorAspect.stage = (Stage) stage;
    }
    
    @FXML
    private void botonRojoClick() {
        System.out.println("Se ha hecho clic en el botón Rojo");
        rootPane.setStyle("-fx-background-color:  RED;");
    }

    @FXML
    private void botonVerdeClick() {
        System.out.println("Se ha hecho clic en el botón Verde");
        rootPane.setStyle("-fx-background-color: GREEN;");
    }

    @FXML
    private void botonAzulClick() {
        System.out.println("Se ha hecho clic en el botón Azul");
        rootPane.setStyle("-fx-background-color: BLUE;");
    }

    @Override
    public void onColorChange(Color color) {
         Platform.runLater(() -> {
             if (color.equals(Color.RED)) {
            	 rootPane.setStyle("-fx-background-color:  RED;");
             } else if (color.equals(Color.GREEN)) {
            	 rootPane.setStyle("-fx-background-color: GREEN;");
             } else if (color.equals(Color.BLUE)) {
            	 rootPane.setStyle("-fx-background-color: BLUE;");
             }
        });
    }

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}