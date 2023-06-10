import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public aspect ColorAspect {
	pointcut colorObserverPointcut(Color color) : call(void notifyColor(Color)) && args(color);
	//Advice para los botones observados.
	after(Color color) returning : colorObserverPointcut(color) {
		System.out.println("El color actual es = " +color.toString());
		//Implementación del aspecto adicional cross cutting. Saldrá una notificación con el color escogido
		showNotification(color);
	}
	private void showNotification(Color color) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Cambio de Color - FUNCIÓN ADICIONAL");
        alert.setHeaderText("Nuevo color seleccionado");
        alert.setContentText("El color actual es: " + color);
        alert.showAndWait();
    }
}