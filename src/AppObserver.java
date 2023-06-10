import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class AppObserver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("observer.fxml"));
			Parent root = (Parent) loader.load();
			observerController controller = loader.getController();
			controller.setStage(primaryStage);
			primaryStage.setScene(new Scene(root, 650,500));
			primaryStage.setTitle("Tarea Aspectos");
			primaryStage.show();
//			root = FXMLLoader.load(getClass().getResource("observer.fxml"));
//			primaryStage.setScene(new Scene(root, 650,500));
//			primaryStage.setTitle("Tarea Aspectos");
//	        primaryStage.show();
		} catch (IOException e) {
			System.out.println("Error al crear la ventana.");
			e.printStackTrace();
			
		}

    }
}
