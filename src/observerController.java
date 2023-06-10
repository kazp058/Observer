import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class observerController implements  ColorChangeObserver{

    @FXML
    private Button botonAzul;

    @FXML
    private Button botonRojo;

    @FXML
    private Button botonVerde;
    
    @FXML
    private VBox rootPane;
    
    
    //Sujetos
    @FXML
    private void botonRojoClick() {
        notifyColor(Color.RED);
        
    }

    @FXML
    private void botonVerdeClick() {
        notifyColor(Color.GREEN);
    }

    @FXML
    private void botonAzulClick() {
        notifyColor(Color.BLUE);
    }
    //Observador
    @Override
    public void notifyColor(Color color) {
    	String colorName = this.toHexString(color);
    	rootPane.setStyle("-fx-background-color: "+colorName+";");
    }

	private String toHexString(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("#%02X%02X%02X", r, g, b);
    }
	
}