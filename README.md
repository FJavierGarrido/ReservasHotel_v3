# Tarea: Reservas Hotel
## Profesor: Andrés Rubio del Río
## Alumno:Francisco Javier Garrido Pomares

En este segundo spring de la tarea consistente en modelar la gestiÃ³n de las **reservas del hotel IES Al-Ãndalus**, se va a continuar usando la implementaciÃ³n basada en arrays para la gestiÃ³n de las colecciones. Pero aÃ±adiremos el patrÃ³n MVC,
haciendo una primera aproximaciÃ³n al mismo que poco a poco iremos mejorando cuando se vayan adquiriendo los conocimientos necesarios. Por tal motivo, haremos una distinciÃ³n entre la **vista**, encargada de interaccionar con el usuario, el **modelo**,
encargado de gestionar los datos y de interactuar con las colecciones y que dividiremos entre **clases de dominio y clases de negocio**. Por Ãºltimo, pero no menos importante, el **controlador** que serÃ¡ el encargado de dirigir toda esta orquesta.

Debes tener en cuenta el problema existente con las referencias, por lo que, al igual que en el primer spring, para cada clase que sea cliente de otra deberÃ¡s devolver referencias a objetos nuevos en los mÃ©todos de acceso.
TambiÃ©n crear nuevas referencias a nuevos objetos cuando los vayamos a asignar a atributos. AdemÃ¡s, en los mÃ©todos de las clases dominio deberÃ¡s devolver una copia profunda de los elementos de la colecciÃ³n en dicho mÃ©todo de acceso.

Por otro lado, dado el buen hacer en la primera entrega, el cliente ha decidido que se aÃ±ada al menÃº de usuario la posibilidad de **realizar operacion de Checkin y Checkout**.

#### Primeros Pasos
1. Realiza un **fork** del repositorio de tu tarea anterior en otro nuevo llamado **ReservasHotel_v1**. Dicho repositorio lo clonarÃ¡s localmente y realizarÃ¡s las diferentes modificaciones que se piden en esta tarea.
2. Modifica el archivo `README.md`. Realiza tu **primer commit**.

#### Reservas
1. Agrega el mÃ©todo `realizarCheckin` para que se establezca la fecha de checkin de la reserva indicada como parÃ¡metro.
2. Agrega el mÃ©todo `realizarCheckout` para que se establezca la fecha de checkout de la reserva indicada como parÃ¡metro.
3. Realiza el **commit** correspondiente.

#### Opcion
1. Modifica el enumerado `Opcion` creado en el spring anterior para que se aÃ±adan las operaciones realizar checkin y realizar checkout, tal y como aparece en el diagrama de clases.
2. Realiza un **commit** con la modificaciÃ³n de este enumerado.

#### Consola
1. Modifica la clase `Consola` para que se incluya el mÃ©todo `leerFechaHora` que nos pedirÃ¡ que introduzcamos una cadena correspondiente a una fecha y hora en el formato adecuado y devolverÃ¡ el objeto `LocalDateTime` correspondiente. Esto se repetirÃ¡ mientras la fecha introducida no sea vÃ¡lida.
2. Realiza el **commit** correspondiente.

#### Modelo
1. Crea la clase `Modelo` en el paquete indicado en el diagrama. Esta clase gestionarÃ¡ todo el modelo de nuestra aplicaciÃ³n. SerÃ¡ la encargada de comunicarse con las tres clases que hacen referencia a las colecciones de datos (huÃ©spedes, habitaciones y reservas).
2. Crea el mÃ©todo `comenzar` que crearÃ¡ la instancia de las clases de negocio.
3. Crea el mÃ©todo `terminar` que simplemente mostrarÃ¡ un mensaje informativo indicando que el modelo ha terminado.
4. Crea los diferentes mÃ©todos `insertar` (para huesped, habitaciÃ³n y reserva).
5. Crea los diferentes mÃ©todos `buscar`, cada uno de los cuales devolverÃ¡ una nueva instancia del elemento encontrado si Ã©ste existe.
6. Crea los diferentes mÃ©todos `borrar` (para huesped, habitaciÃ³n y reserva).
7. Crea los diferentes mÃ©todos `get`, que deben devolver una nueva lista conteniendo nuevas instancias no una copia de los elementos.
8. Crea los mÃ©todos `realizarCheckin` y `realizarCheckout`.
9. Realiza un **commit** con la nueva clase creada.

#### Controlador
1. Crea la clase `Controlador` en el paquete indicado en el diagrama. Esta clase serÃ¡ la encargada de hacer de intermediario entre la vista y el modelo.
2. Crea los atributos con la visibilidad adecuados.
3. Crea el constructor con parÃ¡metros que comprobarÃ¡ que no son nulos y los asignarÃ¡ a los atributos. AdemÃ¡s, debe llamar al mÃ©todo `setControlador` de la vista con una instancia suya.
4. Crea los mÃ©todos `comenzar` y `terminar`, que llamarÃ¡n a los correspondientes mÃ©todos en el modelo y en la vista.
5. Crea los demÃ¡s mÃ©todos, los cuales simplemente harÃ¡n una llamada al correspondiente mÃ©todo del modelo.
6. Realiza un **commit** con la nueva clase creada.


#### Vista
1. Crea la clase `Vista`, en el paquete adecuado.
2. Crea los diferentes atributos que se indican en el diagrama de clases con su visibilidad adecuada.
3. Excepto el mÃ©todo `main`, mueve todos los mÃ©todos existentes en la clase `MainApp` del spring anterior a la clase `Vista`.
4. Crea el mÃ©todo `setControlador` que asignarÃ¡ el controlador pasado al atributo si este no es nulo.
5. Crea el mÃ©todo `comenzar` que mostrarÃ¡ el menÃº, leerÃ¡ una opciÃ³n de consola y la ejecutarÃ¡. RepetirÃ¡ este proceso mientras la opciÃ³n elegida no sea la correspondiente a salir. UtilizarÃ¡ los correspondientes mÃ©todos de la clase `Consola`.
6. Crea el mÃ©todo `terminar` que simplemente mostrarÃ¡ un mensaje de despedida por consola.
7. Modifica el mÃ©todo `ejecutarOpcion` para que permita realizar las operaciones realizar checkin y realizar checkout.
8. Crea el mÃ©todo `realizarCheckin`, que una vez localizada la reserva a la que realizar el checkin, deberÃ¡ llamar al mÃ©todo correspondiente del controlador. Para localizar la reserva deberÃ¡ preguntarse por el huesped de la misma, obtener su lista de reservas y establecer la fecha y hora de checkin de la reserva correspondiente. Hay que tener en cuenta que un huesped puede haber realizado varias reservas para el mismo dÃ­a. AdemÃ¡s, en caso de intentar hacer checkin de una reserva no existente en el dÃ­a indicado para el huÃ©sped, la aplicaciÃ³n deberÃ¡ informar con algÃºn mensaje de lo sucedido.
9. Crea el mÃ©todo `realizarCheckout`, que una vez localizada la reserva a la que realizar el checkout, deberÃ¡ llamar al mÃ©todo correspondiente del controlador. Para localizar la reserva deberÃ¡ preguntarse por el huesped de la misma, obtener su lista de reservas y establecer la fecha y hora de checkout de la reserva correspondiente. Hay que tener en cuenta que un huesped puede haber realizado varias reservas para el mismo dÃ­a. AdemÃ¡s, en caso de intentar hacer checkout de una reserva no existente en el dÃ­a indicado para el huÃ©sped, la aplicaciÃ³n deberÃ¡ informar con algÃºn mensaje de lo sucedido.
10. Realiza un **commit** con la nueva clase creada.

#### Main App
1. Modifica la clase `MainApp` para que tenga un Ãºnico mÃ©todo `main` que serÃ¡ el mÃ©todo de entrada a nuestra aplicaciÃ³n. Este mÃ©todo simplemente crearÃ¡ una vista, un modelo y un controlador, pasÃ¡ndoles las instancias antes creadas. Luego simplemente invocarÃ¡ al mÃ©todo comenzar del controlador.
2. Realiza las pruebas que estimes oportunas y cuando consideres que todo es correcto, realiza el Ãºltimo **commit** y seguidamente realiza el **push** a tu repositorio remoto.

#### Se valorarÃ¡:

- La indentaciÃ³n debe ser correcta en cada uno de los apartados.
- El nombre de las variables debe ser adecuado.
- Se debe utilizar la clase `Entrada` para realizar la entrada por teclado.
- El programa debe pasar todas las pruebas que van en el esqueleto del proyecto y toda entrada del programa serÃ¡ validada, para evitar que el programa termine abruptamente debido a una excepciÃ³n. AdemÃ¡s, que ni decir tiene, el programa no debe contener ningÃºn error lÃ©xico, sintÃ¡ctico, de dependencias, etc.
- La correcciÃ³n ortogrÃ¡fica tanto en los comentarios como en los mensajes que se muestren al usuario.
