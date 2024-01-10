# Tarea: Reservas Hotel
## Profesor: Andrés Rubio del Río
## Alumno:Francisco Javier Garrido Pomares

Tu tarea va a consistir en modelar la gestión de las **reservas del hotel IES Al-Ándalus**. Después de todas las especificaciones y requerimientos anotados, en este **primer spring** de la aplicación el gerente del hotel quiere 
que gestionemos la reserva de habitaciones, de las que se guarda un **identificador**, un número de **puerta**, la **planta** en la que se ubica la habitación, el **precio** que cuesta alojarse por noche, el **tipo de habitación** que es 
(**Suite, Simple, Doble o Triple**). Hay que tener presente que el hotel tiene **tres plantas** y que hay **15 puertas por planta** siendo la **primera, la puerta 0**. En referencia a los huéspedes, en este primer este spring se ha 
decidido que solo se almacene la información referente al huésped que realiza la reserva, de quien se quiere guardar **nombre, DNI, teléfono, email y fecha de nacimiento**.

Cuando a través de la aplicación se realiza la reserva de una habitación, debe registrarse el **huésped** que hace la reserva, la **habitación** que se reserva, el **tipo de régimen (solo alojamiento, alojamiento y desayuno, 
media pensión o pensión completa**) que quiere tener el huésped, la **fecha de inicio** y **de fin de la reserva** y el **número de personas** que van a alojarse en la habitación reservada. Cuando el huésped llegue al hotel, 
también deberá almacenarse la **fecha y hora** en la que realiza el **checkin**. Del mismo modo, cuando el huésped abandone el hotel porque haya finalizado su estancia, deberá guardarse la **fecha y hora** en la que realiza 
el **checkout** así como el **precio** de su alojamiento, que será un campo calculado que contendrá el precio final que debe abonar el huésped teniendo en cuenta el precio de la habitación, el régimen de alojamiento realizado y el número de personas.

En este repositorio de GitHub hay un esqueleto de proyecto **gradle** con las dependencias necesarias del proyecto y que ya lleva incluidos todos los test necesarios que el programa debe pasar.
Para ello te muestro un diagrama de clases para el mismo y poco a poco te iré explicando los diferentes pasos a realizar:

![Diagrama de clases para reservasHotel](https://github.com/andresrubiodelrio/ReservasHotel_v0/blob/master/src/main/resources/uml/reservasHotel.png)


#### Primeros Pasos
1. Lo primero que debes hacer es un **fork** del repositorio donde he colocado el esqueleto de este proyecto.
2. Clona tu repositorio remoto recién copiado en GitHub a un repositorio local que será donde irás realizando lo que a continuación se te pide. Modifica el archivo `README.md` para que incluya tu nombre en el apartado "Alumno". Realiza tu **primer commit**.

#### Huésped
1. Crea la clase `Huesped` en el paquete indicado en el diagrama.
2. Crea los diferentes atributos que se indican en el diagrama de clases con su visibilidad adecuada.
3. Crea el método `formateaNombre`. Este método debe normalizar un nombre eliminando caracteres en blanco de sobra y poniendo en mayúsculas la primera letra de cada palabra y en minúsculas las demás.
4. Crea el método `comprobarLetraDni`. Este método hará uso de los grupos de las expresiones regulares (para ello has debido definir la expresión regular con grupos) para quedarse con el número por un lado y con la letra por otro. Para saber si la letra es válida puedes seguir las instrucciones del siguiente enlace: [Comprobar letra dni](https://calculadorasonline.com/calcular-la-letra-del-dni-validar-un-dni/).
5. Crea los métodos de acceso y modificación de cada atributo con la visibilidad adecuada, teniendo en cuenta que un nombre estará compuesto de palabras separadas por un espacio y cada palabra comenzará con una mayúscula y continuará con minúsculas. El **DNI**, el **teléfono** y el **correo** deben también tener un formato válido. Además, debes comprobar que la letra del **DNI** sea correcta. Debes crear las constantes para las expresiones regulares que luego utilizarás en los métodos de modificación. Los métodos de modificación lanzarán las excepciones adecuadas en caso de que el valor que se pretenda asignar al atributo no sea adecuado. 
6. Crea el método `getIniciales`. Este método devolverá las iniciales del nombre.
7. Crea el **constructor con parámetros** que hará uso de los métodos de modificación.
8. Crea el **constructor copia**.
9. Crea los métodos `equals` y `hashCode`, sabiendo que dos huéspedes se considerarán iguales si su DNI es el mismo.
10. Crea el método `toString` que devuelva la cadena que esperan los tests.
11. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### TipoHabitación
1. Crea el enumerado `TipoHabitacion` teniendo en cuenta que cada instancia del enumerado debe contener el tipo de habitación y el número máximo de personas que pueden alojarse en las habitaciones de dicho tipo.
2. Crea el atributo `cadenaAMostrar` (String).
3. Crea el **constructor** con la visibilidad adecuada, que almacenará en los atributos anteriores los datos pasados por parámetro.
4. Crea el método **getter** indicado en el diagrama de clases.
5. Crea el método **toString** que devuelva la cadena que esperan los tests.
6. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### Habitación
1. Crea la clase `Habitacion` con los atributos y visibilidad adecuados.
2. Crea los métodos de acceso y modificación de cada atributo con la visibilidad adecuada, teniendo en cuenta que el **identificador** de una habitación será el número de planta seguido del número de puerta. Además, debes crear las constantes indicadas en el diagrama de clases y que luego utilizarás en los métodos de modificación. Los métodos de modificación lanzarán las excepciones adecuadas en caso de que el valor que se pretenda asignar al atributo no sea adecuado. En el uso de las constantes debes tener presente que el hotel tiene un máximo de tres plantas, con un número máximo de 15 habitaciones por planta (por tanto, 15 puertas por planta) y que el precio de una habitación (independientemente del tipo que sea) oscila entre 40€ y 150€.
3. Crea el **constructor con parámetros** que hará uso de los métodos de modificación.
4. Crea el **constructor copia**.
5. Una habitación será igual a otra si su identificador es el mismo. Basándote en ello crea los métodos `equals` y `hashCode`.
6. Crea el método `toString` que devuelva la cadena que esperan los tests.
7. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### Régimen
1. Crea el enumerado `Régimen`teniendo en cuenta que cada instancia del enumerado debe contener el tipo de régimen y en qué cantidad se incrementa por persona alojada, el precio de la habitación al elegir dicho régimen:
   1. **Solo Alojamiento** no incrementa el precio. 
   2. **Alojamiento y Desayuno** incrementa el precio en 15€.
   3. **Media Pensión** incrementa el precio en 30€.
   4. **Pensión Completa** incrementa el precio en 50€.
2. Crea los atributos con la visibilidad adecuada.
3. Crea el método `getter` indicado en el diagrama de clase.
4. Crea el **constructor** con la visibilidad adecuada, que almacenará en los atributos anteriores los datos pasados por parámetro.
5. Crea el método `toString` que devuelva la cadena que esperan los tests.
6. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un commit.

#### Reserva
1. Crea la clase `Reserva` con los atributos y visibilidad adecuados.
2. Crea los métodos de acceso y modificación de cada atributo, teniendo en cuenta que:
   1. La **fecha de inicio** de la reserva no puede ser anterior al día que se intenta hacer la reserva.
   2. La **fecha de inicio** de la reserva no puede ser posterior al número de meses indicado por la constante `MAX_NUMERO_MESES_RESERVA`.
   3. La **fecha de fin** de la reserva debe ser posterior a la de inicio.
   4. El **número de personas** que se van a alojar en la habitación no puede superar al número máximo de personas que, por el tipo de habitación reservada, se permiten alojar.
   5. El **checkin** no puede ser anterior al inicio de la reserva.
   6. El **checkout** no puede ser anterior al checkin.
   7. El **checkout** debe hacerse como máximo a las 12:00 horas del día en que finaliza la reserva. Para esto deberás usar la constante `MAX_HORAS_POSTERIOR_CHECKOUT`.
   8. El atributo **precio** debe calcularse teniendo en cuenta el coste de la habitación, el régimen de alojamiento y el número de personas alojadas.
3. Crea el **constructor con parámetros** que hará uso de los métodos de modificación.
4. Crea el **constructor copia** que creará una copia y en el caso del huésped y la habitación creará una nueva instancia llamando a sus constructores copia.
5. Crea el método `devolver` que se encargará de asignar la fecha de devoluión si ésta es correcta.
6. Crea el método `getPrecio` que devolverá el precio del alquiler conforme a la fórmula establecida por nuestro cliente y explicada anteriormente.
7. Una reserva será igual a otra si se realiza sobre la misma habitación y en la misma fecha de inicio. Basándote en ello crea los métodos `equals` y `hashCode`.
8. Crea el método `toString` que devuelva la cadena que esperan los tests.
9. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### Huéspedes
1. Crea la clase `Huespedes`, en el paquete adecuado, con los atributos y métodos especificados en el diagrama y la visibilidad adecuada.
   1. Crea el **constructor con parámetros** que creará una lista de la capacidad indicada en el parámetro e inicializará los atributos de la clase a los valores correspondientes. 
   2. Crea el método `get` que devolverá una copia profunda de la colección haciendo uso del método `copiaProfundaHuespedes`.
   3. Se permitirán `insertar` huéspedes no nulos al final de la colección sin admitir repetidos.
   4. El método `buscar` devolverá un huésped si éste se encuentra en la colección y `null` en caso contrario.
   5. El método `borrar`, si el huésped se encuentra en la colección, lo borrará y desplazará los elementos hacia la izquierda para dejar el array compactado.
2. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### Habitaciones
1. Crea la clase `Habitaciones`, en el paquete adecuado, con los atributos y métodos especificados en el diagrama y la visibilidad adecuada.
   1. Crea el **constructor con parámetros** que creará una lista de la capacidad indicada en el parámetro e inicializará los atributos de la clase a los valores correspondientes.
   2. Crea el método `get` que devolverá una copia profunda de la colección haciendo uso del método `copiaProfundaHabitaciones`.
   3. Se permitirán `insertar` habitaciones no nulas al final de la colección sin admitir repetidos.
   4. El método `buscar` devolverá una habitación si ésta se encuentra en la colección y null en caso contrario.
   5. El método `borrar`, si la habitación se encuentra en la colección, la borrará y desplazará los elementos hacia la izquierda para dejar el array compactado.
2. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### Reservas
1. Crea la clase Reservas, en el paquete adecuado, con los atributos y métodos especificados en el diagrama y la visibilidad adecuada.
   1. Crea el **constructor con parámetros** que creará una lista de la capacidad indicada en el parámetro e inicializará los atributos de la clase a los valores correspondientes.
   2. Crea el método `get` que devolverá una copia profunda de la colección haciendo uso del método `copiaProfundaReservas`.
   3. Se permitirán `insertar` reservas no nulas al final de la colección sin admitir repetidos.
   4. El método `buscar` que devolverá el alquiler si éste se encuentra en la lista y null en caso contrario.
   5. El método `borrar`, si la reserva se encuentra en la colección, la borrará y desplazará los elementos hacia la izquierda para dejar el array compactado.
2. El método `getReservas` que está sobrecargado y devolverá una colección de las reservas realizadas por el huésped pasado por parámetro o una colección de las reservas realizadas para el tipo de habitación indicada como parámetro.
3. El método `getReservasFuturas` que devolverá una colección de las reservas realizadas para la habitación indicada como parámetro y que sean posteriores a la fecha de hoy.
4. Comprueba que la **clase pasa los test** para la misma y cuando lo haga realiza un **commit**.

#### Opcion
1. Crea el enumerado `Opcion` en el paquete indicado en el diagrama cuyas instancias corresponderán con cada una de las opciones del menú de nuestra aplicación. Cada instancia aceptará en su constructor una cadena correspondiente al mensaje que se mostrará por pantalla para dicha opción. Debes crear los atributos y métodos que se especifican en el diagrama, teniendo en cuenta que el método toString devolverá la cadena correspondiente a la concatenación del ordinal de la opción, la cadena " .- " y el mensaje a mostrar por la opción en cuestión.
2. Realiza un **commit** con la creación de este enumerado.

#### Consola
1. Crea la clase `Consola` en el paquete indicado en el diagrama.
2. Crea su **constructor** teniendo en cuenta que es una clase de utilidades y que no tiene sentido instanciar objetos de la misma.
3. Crea el método `mostrarMenu` que mostrará las diferentes opciones de nuestro programa de forma automática teniendo en cuenta cada uno de los objetos instancias del Enumerado Opcion (insertar, buscar, borrar, ...).
4. Crea el método `elegirOpcion` que pedirá que elijamos la opción y devolverá la instancia del enumerado `Opcion` correspondiente.
5. Crea el método `leerHuesped`que nos pedirá los datos correspondientes a un huésped y devolverá un objeto instancia de dicha clase en el caso que los datos introducidos sean correctos o propague la excepción correspondiente en caso contrario.
6. Crea el método `leerClientePorDni` que nos pedirá el dni del huésped y devolverá un huesped con el dni introducido y con el resto de datos ficticios cumpliendo las restricciones de creación de un huésped. En caso contrario, deberá propagar la excepción correspondiente.
7. Crea el método `leerFecha`que nos pedirá que introduzcamos una cadena correspondiente a una fecha en el formato adecuado y devolverá el objeto `LocalDate` correspondiente. Esto se repetirá mientras la fecha introducida no sea válida.
8. Crea el método `leerHabitacion` que nos pedirá los datos correspondientes a una habitación y devolverá un objeto instancia de dicha clase en el caso que los datos introducidos sean correctos o propague la excepción correspondiente en caso contrario.
9. Crea el método `leerHabitacionPorIdentificador` que nos pedirá el número de planta y el número de puerta de una habitación y devolverá una habitación con dichos datos y con el resto de datos ficticios que cumpliendo las restricciones de creación de una habitación. En caso contrario, deberá propagar la excepción correspondiente.
10. Crea el método `leerTipoHabitacion`que pedirá que elijamos un tipo de habitación y devolverá la instancia del enumerado `TipoHabitación` correspondiente.
11. Crea el método `leerRegimen` que pedirá que elijamos un tipo de régimen y devolverá la instancia del enumerado `Regimen` correspondiente.
12. Crea el método `leerReserva` que nos pedirá los datos correspondientes a una reserva y devolverá un objeto instancia de dicha clase en el caso que los datos introducidos sean correctos o propague la excepción correspondiente en caso contrario.
13. Realiza el **commit** correspondiente.

#### MainApp
1. Crea la clase `MainApp` en el paquete indicado en el diagrama.
   1. Crea los diferentes atributos que se indican en el diagrama de clases con su visibilidad adecuada.
   2. Crea el método `ejecutarOpcion` que dada una opción, la ejecute.
   3. Crea el método `insertarHuesped`que nos pedirá los datos de un huésped, haciendo uso de la clase `Consola`, y lo insertará en la colección correspondiente si es posible o informará del problema en caso contrario.
   4. Crea el método `buscarHuesped`que nos pedirá el dni de un huésped, haciendo uso de la clase `Consola`, mostrándonos a dicho huesped o informará de que no existe o informará del problema en caso acontecido.
   5. Crea el método `borrarHuesped` que nos pedirá el dni de un huésped, haciendo uso de la clase `Consola`, borrándolo si es posible o informará del problema en caso contrario.
   6. Crea el método `mostrarHuespedes` que mostrará todos los huéspedes almacenados si es que hay o si no, nos informará de que no hay huéspedes.
   7. Crea el método `insertarHabitacion` que nos pedirá los datos de una habitación, haciendo uso de la clase `Consola`, y lo insertará en la colección correspondiente si es posible o informará del problema en caso contrario.
   8. Crea el método `buscarHabitacion` que nos pedirá el número de puerta y el número de planta de una habitación, haciendo uso de la clase `Consola`, mostrándonos a dicha habitación o informará de que no existe o informará del problema en caso acontecido.
   9. Crea el método `borrarHabitacion` que nos pedirá el número de puerta y el número de planta de una habitación, haciendo uso de la clase `Consola`, borrándolo si es posible o informará del problema en caso contrario.
   10. Crea el método `mostrarHabitaciones` que mostrará todos las habitaciones almacenadas si es que hay o si no, nos informará de que no hay habitaciones.
   11. Crea el método `insertarReserva` que nos pedirá los datos de una reserva, haciendo uso de la clase `Consola`, y lo insertará en la colección correspondiente si es posible o informará del problema en caso contrario. **Debe tenerse en cuenta que para poder insertar una reserva debe haber disponibilidad del tipo de habitación deseada por el huésped en el periodo indicado**.
   12. Crea el método `listarReservas` que está sobrecargado, mostrando todas las reservas almacenadas (si es que hay) del huésped, del tipo de habitación o de la fecha indicada como parámetro. Si no hay, nos informará de que no hay reservas.
   13. Crea el método `getReservasAnulables` que de la colección de reservas recibida como parámetro, devolverá aquellas que sean anulables, es decir, cuya fecha de inicio de la reserva aún no haya llegado.
   14. Crea el método `anularReserva` que pedirá el dni del huésped del que se desea anular una reserva (haciendo uso de la clase `Consola`), obteniendo de todas las reservas de dicho huésped aquellas que sean anulables. En el caso de que no tenga ninguna anulable deberá de informarse de dicha circunstancia. Si solo tiene una reserva anulable deberá confirmarse que realmente se quiere anular. Y por último, en el caso de que el huésped tenga más de una reserva anulable, deberán ser listadas precedidas por un número para que el usuario elija la reserva que desea anular.  
   15. Crea el método `mostrarReservas` que mostrará todas las reservas almacenadas si es que hay o si no, nos informará de que no hay reservas.
   16. Crea el método `consultarDisponibilidad` que devuelve una habitación del tipo indicado por parámetro y que esté disponible entre las fechas de inicio y fin de la reserva, también indicados por parámetro.
   17. Crea el método `main` que nos mostrará el menú de la aplicación, nos pedirá una opción y la ejecutará mientras no elijamos la opción salir. En caso de salir, la aplicación mostrará un mensaje de despedida.
   18. Realiza un **commit** con la creación de esta clase.
   19. Finalmente, realiza el **push** hacia tu repositorio remoto en GitHub.

#### Se valorará:

- La indentación debe ser correcta en cada uno de los apartados.
- El nombre de las variables debe ser adecuado.
- Se debe utilizar la clase `Entrada` para realizar la entrada por teclado.
- El programa debe pasar todas las pruebas que van en el esqueleto del proyecto y toda entrada del programa será validada, para evitar que el programa termine abruptamente debido a una excepción. Además, que ni decir tiene, el programa no debe contener ningún error léxico, sintáctico, de dependencias, etc.
- La corrección ortográfica tanto en los comentarios como en los mensajes que se muestren al usuario.

