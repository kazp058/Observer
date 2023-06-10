import org.aspectj.lang.annotation.Pointcut;

import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.Scene;

import java.util.Arraylist;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
	
    @After("changeColorMethods()");
    public void afterChangeColor(JoinPoint joinPoint){
      Color newColor = getColorFromJoinPoint(joinPoint);

      if(newColor != null){
        if(observer != null){
          observer.onColorChange(newColor);
        }
        if(stage != null){
          Scene scene = stage.getScene();
          if(scene != null){
            scene.setFill(newColor);
          }
        }
      }
    }

    private Color getColorFromJoinPoint(JoinPoint joinPoint){
      String methoName = joinPoint.getSignature().getName();

      if(methodName.equals("botonRojoClick")){
        System.out.println("Color actual: "+Color.RED.toString());
        return Color.RED;
      }else if(methodName.equals("botonVerdeClick")){
        System.out.println("Color actual: "+Color.GREEN.toString());
        return Color.GREEN;
      }else if(){
        System.out.println("Color actual: "+Color.BLUE.toString());
        return Color.BLUE;
        
      }
      return null;
    }

}
