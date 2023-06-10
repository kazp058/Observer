# Patrón Observador: Implementación en el caso de `ColorAspect` y `observerController`

En este caso, el aspecto `ColorAspect` actúa como el observador y el controlador `observerController` actúa como el sujeto.

#### Definición de la interfaz `ColorChangeObserver`

El aspecto `ColorAspect` define una interfaz `ColorChangeObserver` que contiene el método `notifyColor(Color color)`.

#### Implementación del método `notifyColor()`

El controlador `observerController` implementa la interfaz `ColorChangeObserver` y proporciona la implementación del método `notifyColor()` para manejar el cambio de color de la ventana.

#### Activación del aspecto `ColorAspect`

Cuando se realiza un cambio de color en los métodos se crea un pointer cut en el joinpoint de la función `notifyColor(Color)` del controlador `observerController`, el aspecto `ColorAspect` se activa después de la ejecución de este método gracias al Advice y obtiene el parámetro tipo Color.

#### Notificación por consola al observador al cambiar el color de fondo

Ya dentro del advice, se imprime en consola el color actual. Este aspecto es el llamado Observador, que observa a todos los sujetos, en este caso son los eventos de los botones del controlador `observerController`.

#### Notificación por pantalla al observador al cambiar el color de fondo

Después de imprimir por consola se despligua una noficación por pantalla con el código del color seleccionado. Este es un ejemplo de Cross-cutting concern por que estamos separando el notificar al usuario sobre sus cambios de la lógica dentro del controlador.

En resumen, el aspecto `ColorAspect` implementa el patrón observador al actuar como observador de los cambios de color en el controlador `observerController` y notificar al controlador sobre esos cambios mediante la interfaz `ColorObserver`. Esto permite una separación clara entre el código relacionado con el cambio de color y la funcionalidad adicional en el controlador.
