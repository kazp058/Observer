# Patrón Observador: Implementación en el caso de `ColorAspect` y `observerController`

En este caso, el aspecto `ColorAspect` actúa como el observador y el controlador `observerController` actúa como el sujeto.

#### Definición de la interfaz `ColorChangeObserver`

El aspecto `ColorAspect` define una interfaz `ColorChangeObserver` que contiene el método `onColorChange(Color color)`.

#### Implementación del método `onColorChange()`

El controlador `observerController` implementa la interfaz `ColorChangeObserver` y proporciona la implementación del método `onColorChange()` para manejar el cambio de color.

#### Activación del aspecto `ColorAspect`

Cuando se realiza un cambio de color en los métodos `botonRojoClick()`, `botonVerdeClick()` o `botonAzulClick()` del controlador `observerController`, el aspecto `ColorAspect` se activa después de la ejecución de esos métodos utilizando el punto de corte `@After("changeColorMethods()")`.

#### Método `afterChangeColor()` del aspecto `ColorAspect`

En el método `afterChangeColor()` del aspecto `ColorAspect`, se obtiene el nuevo color del punto de corte `JoinPoint` y se verifica si hay un observador registrado (`observer`). Si hay un observador, se llama al método `onColorChange()` del observador y se pasa el nuevo color como parámetro.

#### Registro del controlador como observador

En el controlador `observerController`, el método `initialize()` se utiliza para registrar el controlador como observador del aspecto `ColorAspect` utilizando el método estático `addObserver()` del aspecto. De esta manera, el controlador se suscribe para recibir notificaciones de cambios de color.

#### Notificación al observador al cambiar el color de fondo

Al cambiar el color de fondo de la ventana en el método `afterChangeColor()`, también se activa la notificación al observador. Esto permite que el controlador `observerController` realice alguna acción adicional en respuesta al cambio de color, como mostrar el nuevo color en la consola o realizar alguna otra funcionalidad relacionada.

En resumen, el aspecto `ColorAspect` implementa el patrón observador al actuar como observador de los cambios de color en el controlador `observerController` y notificar al controlador sobre esos cambios mediante la interfaz `ColorObserver`. Esto permite una separación clara entre el código relacionado con el cambio de color y la funcionalidad adicional en el controlador.
