import org.aspectj.lang.annotation.Pointcut;

import javafx.stage.Stage;;

public aspect ColorAspect {

	private ColorChangeObserver observer;
	public static Stage stage;

    public void addObserver(ColorChangeObserver observer) {
    	this.observer = observer;
    }


    @Pointcut("execution(void observerController.botonRojoClick()) || " +
              "execution(void observerController.botonVerdeClick()) || " +
              "execution(void observerController.botonAzulClick())")
    public void changeColorMethods() {}
	
}
